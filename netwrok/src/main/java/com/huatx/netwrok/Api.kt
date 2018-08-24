package com.huatx.netwrok

import android.util.Log
import com.huatx.netwrok.consts.Constants
import com.huatx.netwrok.consts.UriConsts
import com.huatx.netwrok.util.SPUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 设置ApiService
 */
object Api {
    /**
     * 请求超时时间
     */
    /**
     * 请求超时时间
     */
    private val DEFAULT_TIMEOUT = 5L

    private var SERVICE: ApiService? = null


    val default: ApiService
        get() {
            if (SERVICE == null) {
                val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                    //打印retrofit日志
                    Log.d("RetrofitLog", "retrofitBack = " + message)
                })
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                //手动创建一个OkHttpClient并设置超时时间
                val client = OkHttpClient.Builder()
                        .addInterceptor(addHeaderInterceptor())
                        .addInterceptor(loggingInterceptor)
                        .addInterceptor(RequestInterceptor())
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .build()

                SERVICE = Retrofit.Builder()
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(UriConsts.BASE_URL)
                        .build()
                        .create(ApiService::class.java)
            }
            return SERVICE!!
        }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                    // Provide your custom parameter here
                    .addQueryParameter("phoneSystem", "")
                    .addQueryParameter("phoneModel", "")
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 设置头
     */
    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    // Provide your custom header here
                    .header(Constants.KEY_SP_TOKEN, SPUtils.getString(Constants.KEY_SP_TOKEN))
                    .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}
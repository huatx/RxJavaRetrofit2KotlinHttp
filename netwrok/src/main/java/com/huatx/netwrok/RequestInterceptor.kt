package com.huatx.netwrok

import android.preference.Preference
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RequestInterceptor:Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("charset","UTF-8")

                .method(original.method(), original.body())
                .build()
        return chain.proceed(request)
    }
}
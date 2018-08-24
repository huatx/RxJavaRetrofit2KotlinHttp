package com.huatx.netwrok

import com.huatx.netwrok.bean.*
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {


    /**
     * 密码登陆
    hcd-app/auth/login-pass
     */
    @POST("auth/login-pass")

    fun userLogin(@Body route: RequestBody): Observable<ResultData<UserInfoVo>>

    /**
     * 发送验证码(登陆/忘记密码)
    hcd-app/auth/send-code
     */
    @GET("auth/send-code")
    fun sendVeriCode(@QueryMap options: Map<String, Any>): Observable<ResultData<String>>


}
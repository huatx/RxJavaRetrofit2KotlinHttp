package com.huatx.netwrok

import com.google.gson.Gson
import com.huatx.netwrok.Api
import com.huatx.netwrok.ApiService

import okhttp3.RequestBody

object HttpUtil {
    val gson: Gson by lazy { Gson() }
    var requestBody: RequestBody? = null
    val mApiService: ApiService = Api.default


}
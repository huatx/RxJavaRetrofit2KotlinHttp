package com.huatx.knethttp


import com.huatx.netwrok.HttpSimpleSubscriber
import com.huatx.netwrok.HttpUtil
import com.huatx.netwrok.bean.UserInfoVo
import com.huatx.netwrok.consts.Constants
import com.huatx.netwrok.ext.compose1
import com.huatx.netwrok.ext.requestParamsToJson
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable

object LoginModel {
    /**
     * 账户密码登陆
     */
    fun <E> userLogin(userPhone: String, password: String,
                      lifecycleProvider: LifecycleProvider<E>,
                      httpSimpleSubscriber: HttpSimpleSubscriber<UserInfoVo>? = null): Observable<UserInfoVo> {
        val requestParam = HashMap<String, Any>()
        requestParam[Constants.PHONE] = userPhone
        requestParam[Constants.PASSWORD] = password
        HttpUtil.requestParamsToJson(requestParam)
        return HttpUtil.mApiService.userLogin(HttpUtil.requestBody!!)
                .compose1(lifecycleProvider, httpSimpleSubscriber = httpSimpleSubscriber)
    }

    /**
     * 获取验证码
     */
    fun <E> getVeraCode(userPhone: String,
                        phoneCode:String,
                        lifecycleProvider: LifecycleProvider<E>,
                        httpSimpleSubscriber: HttpSimpleSubscriber<String>? = null): Observable<String> {
        val requestParam = HashMap<String, Any>()
        requestParam[Constants.PHONE] = userPhone
        requestParam[Constants.PHONE_CODE] = phoneCode
        return HttpUtil.mApiService.sendVeriCode(requestParam)
                .compose1(lifecycleProvider, httpSimpleSubscriber = httpSimpleSubscriber)
    }


}
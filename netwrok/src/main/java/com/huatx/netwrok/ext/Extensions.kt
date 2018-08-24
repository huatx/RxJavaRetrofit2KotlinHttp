package com.huatx.netwrok.ext

import com.huatx.netwrok.HttpSimpleSubscriber
import com.huatx.netwrok.HttpSimpleTransformer
import com.huatx.netwrok.HttpUtil
import com.huatx.netwrok.bean.ResultData
import com.huatx.netwrok.consts.Constants
import com.huatx.netwrok.util.SPUtils
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.RequestBody

fun HttpUtil.requestParamsToJson(requestParam: HashMap<String, Any>) {
    val toJson = HttpUtil.gson.toJson(requestParam)
    requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), toJson)
}



fun <T : Any, E> Observable<ResultData<T>>.compose1(lifecycleProvider: LifecycleProvider<E>? = null,
                                                    needCertification: Boolean = false,
                                                    httpSimpleSubscriber: HttpSimpleSubscriber<T>? = null): Observable<T> =
        compose(HttpSimpleTransformer(lifecycleProvider, needCertification, httpSimpleSubscriber))


/*
    顶级函数，判断是否登录
 */
fun isLogined():Boolean{
    return SPUtils.getString(Constants.KEY_SP_TOKEN).isNotEmpty()
}

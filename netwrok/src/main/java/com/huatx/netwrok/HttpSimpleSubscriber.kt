package com.huatx.netwrok

import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.huatx.netwrok.consts.Constants

import com.huatx.netwrok.consts.HttpStatus
import com.huatx.netwrok.exception.ApiException
import com.huatx.netwrok.exception.NullDataException
import com.huatx.netwrok.util.SPUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class HttpSimpleSubscriber<T> : Observer<T> {
    companion object {
        private val TAG = "HttpSimpleSubscriber"
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        _onNext(t)
    }

    override fun onError(t: Throwable) {

        var errorCode = HttpStatus.ERROR
        var msg = "请求失败，请稍后再试..."
        when (t) {
            is NullDataException -> {
                _onNext(null)
                return
            }
            is ApiException -> {
                errorCode = t.errorCode

                msg = t.message ?: "请求失败，请稍后再试..."
            }
            is UnknownHostException -> {
                errorCode = HttpStatus.SOCKET_TIMEOUT
                msg = "请检查网络"
            }
            is SocketTimeoutException -> {
                errorCode = HttpStatus.SOCKET_TIMEOUT
                msg = "网络连接超时，请稍后再试..."
            }
            is ConnectException -> {
                errorCode = HttpStatus.SOCKET_TIMEOUT
                msg = "网络连接失败，请稍后再试..."
            }
            is HttpException -> {
                errorCode = HttpStatus.REPEAT_LOGIN

                msg = "账号已在其他设备登陆"
                SPUtils.putString(Constants.KEY_SP_TOKEN, "")
                //发起路由跳转
               ARouter.getInstance().build("/login/LoginActivity").navigation()

            }
        }
        Log.e(TAG, "errorCode:$errorCode $t")
        _onError(errorCode, msg)
    }

    override fun onComplete() {
        _onComplete()
    }

    abstract fun _onNext(retData: T?)

    open fun _onComplete() {

    }

    abstract fun _onError(errorCode: Int, msg: String)
}
package com.huatx.knethttp

import android.os.Bundle
import com.huatx.netwrok.HttpSimpleSubscriber
import com.huatx.netwrok.ProgressSubscriber
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginModel.getVeraCode("", "", this@MainActivity, object : HttpSimpleSubscriber<String>() {
            override fun _onNext(retData: String?) {

            }

            override fun _onError(errorCode: Int, msg: String) {
            }
        })
        LoginModel.getVeraCode("", "", this, object : ProgressSubscriber<String>(this@MainActivity, "xxxx"){
            override fun _onNext(retData: String?) {

            }

            override fun _onError(errorCode: Int, msg: String) {
            }
        })


    }
}

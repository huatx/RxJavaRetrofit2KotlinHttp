package com.huatx.netwrok.common

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.huatx.netwrok.BuildConfig
import kotlin.properties.Delegates

open class BaseApplication : Application() {

    /*
           全局伴生对象
        */
    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
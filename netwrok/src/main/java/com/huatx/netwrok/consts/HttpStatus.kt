package com.huatx.netwrok.consts

object HttpStatus {
    /**
     * 响应成功
     */
    const val SUCCESS = 0

    const val ERROR = -1
    /**
     * 服务器内部错误
     */
    @JvmField
    val SERVER_ERROR = 1
    @JvmField
    val SOCKET_TIMEOUT = -2

    @JvmField
    val AUTHENTICATION_FAILED = 10
    @JvmField
    val TOKEN_HAS_EXPIRED = 11

    @JvmField
    val WRONG_USERNAME = 20
    @JvmField
    val WRONG_PASSWORD = 21

    @JvmField
    val VERIFICATION_CODE_INVALID = 201
    @JvmField
    val VERIFICATION_CODE_ERROR = 202
    @JvmField
    val PHONE_NOT_REGISTERED = 203
    @JvmField
    val PHONE_HAS_REGISTERED = 210

    @JvmField
    val INVALID_PERMITION = 10004
    @JvmField
    val PASS_RESET = 10005
    const val REPEAT_LOGIN = 10006


//    INVALID_PERMITION(10004, "无权限"),
//    PASS_RESET(10005, "密码已修改"),
//    REPEAT_LOGIN(10006, "账号已在其他设备登陆")
    /**
     * 网络连接超时
     */
    @JvmField
    val NETWORK_ERROR = 1004
}
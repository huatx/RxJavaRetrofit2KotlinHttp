package com.huatx.netwrok.consts

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛
/**
 * desc: 常量
 */
object Constants {
    //SP表名
    const val TABLE_PREFS = "hx_recharge"
    //Token Key
    const val KEY_SP_TOKEN = "token"
    const val KEY_SP_USERPHONENUM = "userPhoneNum"
    const val KEY_SP_USERPWD = "userPwd"


    //    登陆相关请求参数key
    const val PHONE: String = "phone"
    const val PASSWORD: String = "password"
    const val OLD_PASSWORD: String = "oldPassword"
    const val PHONE_CODE: String = "code"


    const val PHONE_AREA: String = "phoneArea"

    //我的模块
    const val ADDRESS: String = "address"
    const val BIRTHDAY: String = "birthday"
    //    020201开启020202关闭
    const val ENABLE_LOCATION_ON: String = "020201"
    const val ENABLE_LOCATION_OFF: String = "020201开启020202关闭"


    //工作模块
    const val SEARCH_KEY: String = "searchKey"
    const val CAR_NUMBER: String = "carNumber"
    const val NUMBER_REMARK: String = "numberRemark"
    const val CAR_VIN: String = "carVin"
    const val ID: String = "id"
    const val TRAVERSE_TIME: String = "traverseTime"
    const val ORG_ID: String = "orgId"
    const val PARKING_ID: String = "parkingId"


    const val STATION_ID:String="stationId"
    const val STATION_NAME:String="stationName"
    const val CAR_AREA:String="carArea"
    const val FIND_TYPE:String="findType"
    const val FAULT_DESCRIPTION:String="faultDescription"
    const val FAULT_TIME:String="faultTime"
    const val MSG_CONTENTS:String="msgContents"
    const val PILE_ID:String="pileId"
    const val PILE_NAME:String="pileName"
    const val SEARCH_DATE:String="searchDate"
    const val TYPE:String="type"
    const val STATE:String="state"
    const val ALARM_ID:String="alarmId"
    const val SEARCH_CONTENT:String="searchContent"


    //查询所有公司请求码
    const val requestAllCompanyCode=0x001
    //选择站场的请求码
    const val requestSelectParkSpotCode=0x002
    const val requestStopCarAreaCode=0x003
    const val resultSelectParkSpotCode="UserChooseStationBean"

    const val resultSelectStationId="UserChooseStationId"

    const val resultStopCarAreaName="stopCarArea"

    const val resultAllCompany="carCompany"
    const val resultAllCompanyId="carCompanyId"

    const val REQUEST_CODE_SELECT = 100
    const val REQUEST_CODE_PREVIEW = 101


    //分页参数
    const val CURRENT: Int = 1
    //分页大小
    const val SIZE: Int = 10

    /**
     * LiveDataBus 常量
     */


    /*
    *vlayout类型区
    */
    const val typeTitle = 1
    const val typeGv = 2
    const val typeLv = 3
    const val typeLv1 = 4
    const val typeLv2 = 5


}
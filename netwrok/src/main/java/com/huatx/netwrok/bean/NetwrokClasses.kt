package com.huatx.netwrok.bean

import java.io.Serializable
import java.util.*

data class ResultData<T>(var code: Int, val message: String, val data: T?)

data class UserInfoVo(val expire: Long, val timestamp: Long, val token: String) : Serializable

data class PhoneAreaCode(val ab: String, val code: String, val country: String) : Serializable
//工作区的bean
data class WorkManageMenu(val id: Int, val moduleName: String, val menus: ArrayList<MenusBean>) : Serializable

data class MenusBean(val orderNum: Int, val resourceCode: String, val resourceName: String, val resourceUrl: String) : Serializable
//我的界面
data class MeUserBean(val address: String, val birthday: String,
                      val enableLocation: String,
                      val enableLocationText: String,
                      val phone: String,
                      val photoUrl: String,
                      val positionId: Long,
                      val positionName: String,
                      val realName: String,
                      val sex: String,
                      val sexText: String,
                      val stations: ArrayList<UserChooseStationBean>,
                      val userCode: String,
                      val userId: Long
) : Serializable


//我的充电站
data class UserChooseStationBean(
        val stationId: String,
        val stationName: String,
        var isSelect: Boolean
) : Serializable

//oss令牌
data class OssFileTokenBean(
        val accessKeyId: String,
        val accessKeySecret: String,
        val expiration: String,
        val securityToken: String
) : Serializable

//公交移车
//自编号/车牌号分页查询车辆信息
data class TcarSearch(
        val current: Int,
        val pages: Int,
        val records: ArrayList<Record>,
        val size: Int,
        val total: Int
) : Serializable

data class Record(
        var carNumber: String,
        val carVin: String,
        val numberRemark: String,
        val orgId: String,
        val orgName: String
) : Serializable
//查询车辆所属公司信息

data class TCarById(
        val carId: String,
        val carNumber: String,
        val carVin: String,
        val numberRemark: String,
        val orgId: String,
        val pagePGroupReq: PagePGroupReq
) : Serializable

data class PagePGroupReq(
        val current: Int,
        val isAsc: Boolean,
        val orderByField: Any,
        val orgId: String,
        val orgName: String
) : Serializable

//根据车牌号查询最新的记录
data class CarNumAttributeQuery(
        val belongPgroup: String,
        val carNumber: String,
        val deliveryFingerprint: String,
        val deliveryTime: String,
        val id: String,
        val numberRemark: String,
        val pageTcarInfoVO: PageTcarInfoVO,
        val parkingId: String,
        val sigenFingerprint: String,
        val signTime: String,
        val stationId: String,
        val traverseTime: String
) : Serializable

data class PageTcarInfoVO(
        val chargElec: Double,
        val endSoc: String,
        val endTime: String,
        val startTime: String
) : Serializable
//查询全部公司

data class QueryAllCompanyMananage(
        val current: Int,
        val pages: Int,
        val records: ArrayList<RecordCar>,
        val size: Int,
        val total: Int
) : Serializable

data class RecordCar(
        val codeId: String,
        val count: String,
        val orgId: String,
        val orgName: String,
        val state: String
) : Serializable

/**
 * 选择车牌号的bean
 */
data class CarSelectVO(
        var content: String,
        var isSelect: Boolean
) : Serializable

/**
 * 模糊查询车位
 */

data class CarStopArea(
        val carArea: String,
        val id: String,
        val state: Any,
        val stationId: String,
        var isSelect: Boolean
) : Serializable

/**
 * 职位管理
 */

data class JobPositionVo(
        val current: Int,
        val pages: Int,
        val records: ArrayList<JobRecord>,
        val size: Int,
        val total: Int
) : Serializable

data class JobRecord(
        val notifyCodes: ArrayList<String>,
        val positionId: Long,
        val positionName: String,
        val resourceCodes: ArrayList<String>
) : Serializable

data class JobItemVO(
        var positionIcon: Int,
        var positionJobName: String
) : Serializable


data class SignTime(
        val signTime: String
) : Serializable

/**
 * 电桩搜索
 */
data class PileSearch(
        val current: Int,
        val pages: Int,
        val records: List<PileSearchRecord>,
        val size: Int,
        val total: Int
) : Serializable

data class PileSearchRecord(
        val chargingMethodText: String,
        val commAddr: String,
        val gunSum: Int,
        val pileId: String,
        val pileName: String
) : Serializable


data class FaultAlarmPage(
        val current: Int,
        val pages: Int,
        val records: ArrayList<FaultAlarmRecord>,
        val size: Int,
        val total: Int
) : Serializable

data class FaultAlarmRecord(
        val alarmContent: String,
        val alarmDate: String,
        val alarmId: String,
        val pileName: String,
        val processTime: String,
        var type: Int
) : Serializable


data class FaultPage(
        val current: Int,
        val pages: Int,
        val records: ArrayList<FaultPageRecord>,
        val size: Int,
        val total: Int
) : Serializable


data class FaultPageRecord(
        val carNumber: Any,
        val createTime: String,
        val faultId: String,
        val faultType: Int,
        val findType: Any,
        val findTypeText: Any,
        val finishTime: String,
        val numberRemark: Any,
        val pileName: String,
        val state: String,
        val stateText: String
) : Serializable

data class FaultAlarmInfo(
        val alarmContent: String,
        val alarmDate: String,
        val alarmId: String,
        val chargingMethodText: String,
        val commAddr: String,
        val gunSum: Int,
        val pileId: String,
        val pileName: String,
        val processTime: String,
        val state: Int,
        val stateText: String,
        val stationName: String
) : Serializable

//告警数量
data class FaultAlarmCount(
        val alarmCount: Int,
        val processCount: Int
) : Serializable

//故障数量
data class FaultCount(
        val allFaultCount: Int,
        val finishCount: Int,
        val unsolvedCount: Int
) : Serializable
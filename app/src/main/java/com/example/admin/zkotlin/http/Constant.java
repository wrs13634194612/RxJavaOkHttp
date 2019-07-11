package com.example.admin.zkotlin.http;

/**
 * Created by yanchengmeng on 2016/12/16.
 */
public interface Constant {

    String NETWORK_ERROR = "网络请求失败, 请稍后重试";
    String HEADERNAME = "accessToken"; // 请求头名称

    //TODO 修改域名
    // 正式环境
    String DOMAIN = "http://118.24.55.19:9101";

    String LOGIN_DOMAIN = "http://118.24.55.19:9100";

    // 获得单个柜子的详情
    String GET_SIGNLE_DETAIL = DOMAIN + "/mgmt/cabinet/cabinets/%s";

    // 获得库房详情
    String GET_STOREROOM_DETAIL = DOMAIN + "/mgmt/cabinet/%s";


    //=============我是分割线========================

    // 获取用户名下预约的设备信息
    String GET_RESERVATION_DEVICES = DOMAIN + "/app/cabinet/my/reservationDevices?userId=%s";

    // 提交领用归还订单
    String POST_BORROW = DOMAIN + "/app/cabinet/my/borrow";

    // 获取员工管理列表
    String GET_MEMBERS = DOMAIN + "/app/cabinet/admin/members";

    // 获得一个用户的详情
    String GET_MEMBER_DETAIL = DOMAIN + "/app/cabinet/members/%s";

    // 解除绑定rfid
    String POST_UNTIED_RFID = DOMAIN + "/app/cabinet/members/%s";

    // 解除绑定指纹
    String POST_UNTIED_FINGER_PRINTID = DOMAIN + "/app/cabinet/members/%s";

    // 获得设备柜信息
    String GET_DEVICE_CABINETS_INFO = DOMAIN + "/app/cabinet/cabinets/%s";

    // 获取电池柜信息
    String GET_BATTERY_CABINETS_INFO = DOMAIN + "/app/cabinet/cabinets/battery/%s";

    // 获取电池槽信息
    String GET_BATTERY_SLOT_INFO = DOMAIN + "/app/cabinet/cabinets/battery/slots/%s";

    // 获取电池详细信息
    String GET_BATTERY_DETAIL = DOMAIN + "/app/cabinet/batteries/%s";

    // 柜子的门是否全关判断
    String IS_ALL_CLOSE = DOMAIN + "/app/cabinet/cabinets/%s/doors";

    // 获取所有的未处理的告警信息
    String GET_ALARM = DOMAIN + "/app/cabinet/warns/undisposed";

    // 发起绑定RFID
    String GET_BIND_RFID = DOMAIN + "/app/cabinet/rfid";

    // 发起绑定指纹
    String GET_BIND_FINGER_PRINT = DOMAIN + "/app/cabinet/fingerPrint";

    // 登录
    String LOGIN = DOMAIN + "/app/login";

    // 登出
    String LOGOUT = DOMAIN + "/app/logout";

    // 设备柜名称
    String DEVICE_CABINET_NAME = "deviceCabinetName";

    // 电池柜名称
    String BATTERY_CABINET_NAME = "batteryCabinetName";

    String MODEL = "model";

    String SPECIFIC = "specific";

    String BATTERY = "BATTERY";

    String PART = "PART";

    String DEVICE = "DEVICE";

    String UNKNOWN = "UNKNOWN";

    String IP_ADDRESS = "ipAddress";

    String MAIN_CONTROL_SN = "mainControlSn";

    String DOWNLOAD_ADDRESS = "downloadAddress";

    String ACCESS_TOKEN = "accessToken";
}

package com.ufi.pdioms.cabinet.http

import android.content.Context
import android.util.Log
import com.example.admin.zkotlin.entiy.UserPwd
import com.example.admin.zkotlin.http.Constant
import com.example.admin.zkotlin.http.HttpManager
import com.example.admin.zkotlin.util.JsonUtil
import rx.Observer

// APP接口请求
class HttpHelper private constructor(private var context: Context) {

    private val TAG = "HttpHelper"

    companion object {
        @Volatile
        private var instance: HttpHelper? = null

        fun getInstance(context: Context) =
                instance ?: synchronized(this) {
                    instance ?: HttpHelper(context).also { instance = it }
                }
    }


    // 获得单个柜子的详情
    fun getStaffMemberDetail(cabinetSn: String, observer: Observer<String>) {
        var url = String.format(Constant.GET_SIGNLE_DETAIL, cabinetSn)
        println("url:"+url)
      //  val urls = "http://118.24.55.19:9101/app/cabinet/cabinets/battery/slots/TEST_SLOT_4";
        HttpManager.getInstance(context).getJson(url, "", observer)
    }

    // 获得库房详情
    fun getStoreroomDetail(cabinetSn: String, observer: Observer<String>) {
        var url = String.format(Constant.GET_SIGNLE_DETAIL, cabinetSn)
        println("url:"+url)
        HttpManager.getInstance(context).getJson(url, "", observer)
    }


  /*  // 重命名库房
    fun renameStroom(memberId: String?, rfid: String?, observer: Observer<String>) {
        var url = String.format(Constant.POST_UNTIED_RFID, memberId)
        var map = HashMap<String, String>()
        map.put("rfid", rfid!!)
        HttpManager.getInstance(context).post(url, "", JsonUtil.obj2json(map), observer)
    }*/



    // 用户名、密码登录
    fun passwordLogin(username: String, password: String, observer: Observer<String>) {
        var url = Constant.LOGIN
        var map = HashMap<String, Any>()
        map.put("loginType","USER_PASS")
        var userPwd = UserPwd()
        userPwd.username = username
        userPwd.password = password
        var map2 = HashMap<String,Any>()
        map2.put("userPwd",userPwd)
        map.put("loginData", map2)
        Log.e(TAG, JsonUtil.obj2json(map))
        HttpManager.getInstance(context).post(url, "", JsonUtil.obj2json(map), observer)
    }

}
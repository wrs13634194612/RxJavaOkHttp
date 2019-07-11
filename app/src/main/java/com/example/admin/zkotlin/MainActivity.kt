package com.example.admin.zkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ufi.pdioms.cabinet.http.HttpHelper
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observer

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_singnle_detail.setOnClickListener(this)
        btn_storeroom_detail.setOnClickListener(this)
        btn_rename_storeroom.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_singnle_detail ->{
                //匿名内部类中调用Activity当前对象
                HttpHelper.getInstance(this@MainActivity).getStaffMemberDetail("TEST_DC_1",object:Observer<String>{

                    override fun onError(e: Throwable?) {
                        //事件队列异常 同时队列自动终止
                        println("json rxjava Observer onError")
                    }

                    override fun onNext(t: String?) {
                        //RxJava的事件回调方法，针对普通事件
                        //收到json 直接解析  然后 eventbus把值传递出去
                        println("json rxjava Observer onNext:"+t.toString())
                    }

                    override fun onCompleted() {
                        //事件队列完结 当不会再有新的 onNext() 发出时 触发此方法
                        println("json rxjava Observer onCompleted")
                    }
                })
            }

            R.id.btn_storeroom_detail ->{
                HttpHelper.getInstance(this@MainActivity).getStoreroomDetail("storerooms",object :Observer<String>{
                    override fun onError(e: Throwable?) {
                        println("json btn_storeroom_detail onError")
                    }

                    override fun onNext(t: String?) {
                        println("json btn_storeroom_detail onNext")
                    }

                    override fun onCompleted() {
                        println("json btn_storeroom_detail onCompleted")
                    }

                })
            }

            R.id.btn_rename_storeroom -> {
              //  HttpHelper.getInstance(this@MainActivity).getStoreroomDetail()
            }


        }
    }
}

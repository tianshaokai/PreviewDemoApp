package com.tianshaokai.previewdemo

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tianshaokai.previewdemo.adapter.AppListAdapter
import com.tianshaokai.previewdemo.adapter.AppListAdapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var appListAdapter: AppListAdapter? = null

    private val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCheck()

        initView()

        addData()
    }

    private fun initCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permission, 101)
        } else {

        }
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(this)
        rvAppList.layoutManager = linearLayoutManager
        appListAdapter = AppListAdapter()
        rvAppList.adapter = appListAdapter
        appListAdapter?.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(adapter: AppListAdapter, view: View, position: Int) {
//                Toast.makeText(this@MainActivity, "a", Toast.LENGTH_SHORT).show()




            }
        })
    }

    private fun addData() {
        val list:ArrayList<String> = arrayListOf()
        list.add("1")
        list.add("2")
        list.add("3")
        list.add("4")
        list.add("5")
        list.add("6")
        appListAdapter?.addData(list);
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


    }

}

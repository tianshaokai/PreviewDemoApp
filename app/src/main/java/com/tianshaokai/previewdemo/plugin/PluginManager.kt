package com.tianshaokai.previewdemo.plugin

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import dalvik.system.DexClassLoader

object PluginManager {

    private var dexClassLoader:DexClassLoader? = null
    private var pluginPackageInfo: PackageInfo? = null

    fun loadApk(context: Context, path: String) {
        dexClassLoader = DexClassLoader(path, context.getDir("dex", Context.MODE_PRIVATE).absolutePath, null, context.classLoader)

        pluginPackageInfo = context.packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES)


//        val assetManager:AssetManager = AssetManager::class




    }

}
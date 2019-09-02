package com.tianshaokai.previewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tianshaokai.previewdemo.R

class AppListAdapter : RecyclerView.Adapter<AppListAdapter.ViewHolder>() {

    private var appList: MutableList<String>? = null
    private var mOnItemClickListener: OnItemClickListener? = null

    init {
        this.appList = mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app_list_layout, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            mOnItemClickListener?.onItemClick(this, view, viewHolder.adapterPosition)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return appList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvApp.text = appList?.get(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvApp: TextView = itemView.findViewById(R.id.tvApp)
    }

    fun addData(appList: List<String>) {
        this.appList?.addAll(appList)

        notifyDataSetChanged()
    }


    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }


    interface OnItemClickListener {

        fun onItemClick(adapter: AppListAdapter, view: View, position: Int)
    }

}
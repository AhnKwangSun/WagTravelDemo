package com.kwang.demowagtravel.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.kwang.demowagtravel.R
import com.kwang.demowagtravel.pojos.SingleNoMarginHorizontal

import kotlin.collections.ArrayList


class NoMarginHorizontalAdapter(data: ArrayList<SingleNoMarginHorizontal>) : RecyclerView.Adapter<NoMarginHorizontalAdapter.MyViewHolder>() {

    internal var data = ArrayList<SingleNoMarginHorizontal>()

    init {
        this.data = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_single_row_no_margin, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.image.setImageResource(data[position].images)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: ImageView

        init {
            image = itemView.findViewById<View>(R.id.image_view) as ImageView
        }
    }
}

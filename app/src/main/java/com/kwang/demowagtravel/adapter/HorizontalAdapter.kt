package com.kwang.demowagtravel.adapter

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.kwang.demowagtravel.R
import com.kwang.demowagtravel.pojos.SingleHorizontal

import java.util.ArrayList


class HorizontalAdapter(data: ArrayList<SingleHorizontal>) : RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>() {

    internal var data = ArrayList<SingleHorizontal>()

    init {
        this.data = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_single_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.infomation.text = data[position].infomation
        holder.title.text = data[position].title
        holder.serachDigit.text = data[position].serachDigit
        holder.reserveStatus.text = data[position].reserveStatus
        holder.oldPrice.text = data[position].oldPrice
        holder.renewalPrice.text = data[position].renewalPrice
        holder.image.setImageResource(data[position].images)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: ImageView
        internal var heart: ImageButton
        internal var infomation: TextView
        internal var title: TextView
        internal var serachDigit: TextView
        internal var reserveStatus: TextView
        internal var oldPrice: TextView
        internal var renewalPrice: TextView


        var wishcheck: Int = 0

        init {
            image = itemView.findViewById<View>(R.id.image_view) as ImageView
            heart = itemView.findViewById<View>(R.id.wishlist) as ImageButton
            infomation = itemView.findViewById<View>(R.id.infomation) as TextView
            title = itemView.findViewById<View>(R.id.title) as TextView
            serachDigit = itemView.findViewById<View>(R.id.searchDigit) as TextView
            reserveStatus = itemView.findViewById<View>(R.id.reserveStatus) as TextView
            oldPrice = itemView.findViewById<View>(R.id.oldPrice) as TextView
            renewalPrice = itemView.findViewById<View>(R.id.renewalPrice) as TextView

            itemView.setOnClickListener {
                var position: Int = adapterPosition
                Toast.makeText(itemView.context, "아이템" + position.toString() + "번",Toast.LENGTH_LONG).show()
            }

            heart.setOnClickListener {
                var position: Int = adapterPosition
                if(data[position].wishList == 0) {
                    heart.setImageResource(R.mipmap.fullheart)
                    data[position].wishList = 1
                } else if(data[position].wishList == 1) {
                    heart.setImageResource(R.mipmap.emptyheart)
                    data[position].wishList = 0
                }
            }
        }
    }

}

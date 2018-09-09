package com.kwang.demowagtravel.adapter

import android.content.Context
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang.demowagtravel.MainActivity
import com.kwang.demowagtravel.R
import com.kwang.demowagtravel.pojos.SingleHorizontal
import com.kwang.demowagtravel.pojos.SingleVertical
import java.util.*

class MainAdapter(private val context: Context, private val items: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VERTICAL = 1
    private val HORIZONTAL = 2
    private val NOMARGINHORIZONTAL = 3
    private val lastPosition = -1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View
        val holder: RecyclerView.ViewHolder
        when (viewType) {
            VERTICAL -> {
                view = inflater.inflate(R.layout.vertical, parent, false)
                holder = VerticalViewHolder(view)
            }
            HORIZONTAL -> {
                view = inflater.inflate(R.layout.horizontal, parent, false)
                holder = HorizontalViewHolder(view)
            }
            NOMARGINHORIZONTAL -> {
                view = inflater.inflate(R.layout.horizontal, parent, false)
                holder = NoMarginHorizontalViewHolder(view)
            }

            else -> {
                view = inflater.inflate(R.layout.horizontal, parent, false)
                holder = HorizontalViewHolder(view)
            }
        }


        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VERTICAL) {
            verticalView(holder as VerticalViewHolder)
        }
        else if (holder.itemViewType == HORIZONTAL) {
            horizontalView(holder as HorizontalViewHolder)
        }
        else if (holder.itemViewType == NOMARGINHORIZONTAL) {
            noMarginhorizontalView(holder as NoMarginHorizontalViewHolder)
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position] is SingleVertical)
        {
            println(items[position])
            return VERTICAL
        }else if (items[position] is SingleHorizontal) {
            println(items[position])
            return HORIZONTAL
        } else return NOMARGINHORIZONTAL
    }

    private fun verticalView(holder: VerticalViewHolder) {

        val adapter1 = VerticalAdapter(MainActivity.verticalData)
        holder.recyclerView.layoutManager = LinearLayoutManager(context)
        holder.recyclerView.adapter = adapter1
    }


    private fun horizontalView(holder: HorizontalViewHolder) {
        val adapter = HorizontalAdapter(MainActivity.horizontalData)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.adapter = adapter
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(holder.recyclerView)
    }

    private fun noMarginhorizontalView(holder: NoMarginHorizontalViewHolder) {
        val adapter = NoMarginHorizontalAdapter(MainActivity.noMarginHorizontalData)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.adapter = adapter
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(holder.recyclerView)
    }

    inner class HorizontalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById<View>(R.id.inner_recyclerView) as RecyclerView
        }
    }

    inner class NoMarginHorizontalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById<View>(R.id.inner_recyclerView) as RecyclerView
        }
    }

    inner class VerticalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById<View>(R.id.inner_recyclerView) as RecyclerView
        }
    }

}

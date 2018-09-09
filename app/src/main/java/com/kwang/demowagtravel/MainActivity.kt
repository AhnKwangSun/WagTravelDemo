package com.kwang.demowagtravel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.kwang.demowagtravel.adapter.HorizontalAdapter
import com.kwang.demowagtravel.adapter.MainAdapter
import com.kwang.demowagtravel.adapter.NoMarginHorizontalAdapter
import com.kwang.demowagtravel.pojos.SingleHorizontal
import com.kwang.demowagtravel.pojos.SingleNoMarginHorizontal
import com.kwang.demowagtravel.pojos.SingleVertical

class MainActivity : AppCompatActivity() {
    private val objects = ArrayList<Any>()

    private val `object`: ArrayList<Any>
        get() {
            objects.add(noMarginHorizontalData[0])
            objects.add(horizontalData[0])
            return objects
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  val recyclerView = findViewById<View>(R.id.recycler_View) as RecyclerView
        val adapter = MainAdapter(this, `object`)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/

        loadSecond()
        loadFirst()
    }

    private fun loadFirst(){
        var firstAdapter = HorizontalAdapter(horizontalData)
        var firstRecyclerView = findViewById<View>(R.id.recycler_View) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        firstRecyclerView.layoutManager = layoutManager
        firstRecyclerView.adapter = firstAdapter
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(firstRecyclerView)
    }

    private fun loadSecond() {
        var firstAdapter = NoMarginHorizontalAdapter(noMarginHorizontalData)
        var firstRecyclerView = findViewById<View>(R.id.recycler_View2) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        firstRecyclerView.layoutManager = layoutManager
        firstRecyclerView.adapter = firstAdapter
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(firstRecyclerView)
    }



    companion object {

        val verticalData: ArrayList<SingleVertical>
            get() {
                val singleVerticals = ArrayList<SingleVertical>()
            return singleVerticals
    }


    val horizontalData: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.charlie, "Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", "2010/2/1"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.mrbean, "Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", "2010/2/1"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.jim, "Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", "2010/2/1"))
            return singleHorizontals
        }

    val noMarginHorizontalData: ArrayList<SingleNoMarginHorizontal>
            get() {
                val singleNoMarginHorizontals = ArrayList<SingleNoMarginHorizontal>()
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.charlie, "Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", "2010/2/1"))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.mrbean, "Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", "2010/2/1"))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.jim, "Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", "2010/2/1"))
                return singleNoMarginHorizontals
            }
    }
}

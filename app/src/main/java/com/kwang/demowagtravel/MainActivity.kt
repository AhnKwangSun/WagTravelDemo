package com.kwang.demowagtravel

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.kwang.demowagtravel.adapter.HorizontalAdapter
import com.kwang.demowagtravel.adapter.NoMarginHorizontalAdapter
import com.kwang.demowagtravel.pojos.SingleHorizontal
import com.kwang.demowagtravel.pojos.SingleNoMarginHorizontal
import kotlinx.android.synthetic.main.horizontal_single_row.view.*
import kotlinx.android.synthetic.main.horizontal_single_row_no_margin.view.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val objects = ArrayList<Any>()
    private var timer: Timer? = null

    private val `object`: ArrayList<Any>
        get() {
            objects.add(topGallery[0])
            objects.add(aroundTravel[0])
            return objects
        }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  val recyclerView = findViewById<View>(R.id.recycler_View) as RecyclerView
        val adapter = MainAdapter(this, `object`)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/
        loadTopGallery()
        loadAroundTravel()
        loadRecentSearchTravel()
        loadFamousTravelPlace()
        loadFamousAttractions()
        loadThemeTravel()
        loadTravelGuideBook()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun loadTopGallery() {
        var Adapter = NoMarginHorizontalAdapter(topGallery)
        var recyclerView = findViewById<View>(R.id.recycler_View) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        recyclerView.setOnScrollChangeListener { view: View, scrollX: Int,scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            var cur: Int = (layoutManager).findLastCompletelyVisibleItemPosition() + 1
            if (cur > 0) recyclerView.currentPage.setText("$cur/${recyclerView.adapter.itemCount}")
        }
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        timer = Timer().apply {
            schedule(object : TimerTask(){
                override fun run() {
                    recyclerView.smoothScrollBy(300,0)
                    recyclerView.smoothScrollToPosition(((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() + 1) % topGallery.size)
                }
            },0,5000)
        }
    }

    private fun loadAroundTravel() {
        var Adapter = HorizontalAdapter(aroundTravel)
        var recyclerView = findViewById<View>(R.id.recycler_View2) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun loadRecentSearchTravel() {
        var Adapter = HorizontalAdapter(recentSearchTravel)
        var recyclerView = findViewById<View>(R.id.recycler_View3) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun loadFamousTravelPlace() {
        var Adapter = HorizontalAdapter(famousTravelPlace)
        var recyclerView = findViewById<View>(R.id.recycler_View4) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun loadFamousAttractions() {
        var Adapter = HorizontalAdapter(famousAttractions)
        var recyclerView = findViewById<View>(R.id.recycler_View5) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun loadThemeTravel() {
        var Adapter = HorizontalAdapter(themeTravel)
        var recyclerView = findViewById<View>(R.id.recycler_View6) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun loadTravelGuideBook() {
        var Adapter = HorizontalAdapter(travelGuideBook)
        var recyclerView = findViewById<View>(R.id.recycler_View7) as RecyclerView
        var layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }


    companion object {


    val topGallery: ArrayList<SingleNoMarginHorizontal>
            get() {
                val singleNoMarginHorizontals = ArrayList<SingleNoMarginHorizontal>()
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.one))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.two))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.three))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.four))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.five))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.six))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.seven))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.eight))
                singleNoMarginHorizontals.add(SingleNoMarginHorizontal(R.mipmap.nine))
                return singleNoMarginHorizontals
            }
    }

    val aroundTravel: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }

    val recentSearchTravel: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }

    val famousTravelPlace: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }

    val famousAttractions: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }


    val themeTravel: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }
    val travelGuideBook: ArrayList<SingleHorizontal>
        get() {
            val singleHorizontals = ArrayList<SingleHorizontal>()
            singleHorizontals.add(SingleHorizontal(R.mipmap.japan, "내일부터 사용 가능", "일본 오사카 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.china, "내일부터 사용 가능", "중국 그랜드캐니언 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.tiwan, "내일부터 사용 가능", "대만 야시장 여행","13,418","411","128,000","100,000"))
            singleHorizontals.add(SingleHorizontal(R.mipmap.singapol, "내일부터 사용 가능", "싱가폴 여행","13,418","411","128,000","100,000"))
            return singleHorizontals
        }
}

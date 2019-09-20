package com.utehy.discovermusic.widget.slider

import android.content.Context
import android.os.Handler
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.utehy.discovermusic.R
import me.relex.circleindicator.CircleIndicator

import java.util.*


public class CustomSliderSlideShow : LinearLayout {
    private var imageModelArrayList: ArrayList<Int>? = null
    private lateinit var mPager: ViewPager
//    private lateinit var tvPager: TextView
    private var currentPage = 0
    private var NUM_PAGES = 0
    private val TIME_DELAY: Long = 4000
    private lateinit var circleIndicator: CircleIndicator


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        val view: View = View.inflate(context, R.layout.custom_slider_slide_show, this)
        imageModelArrayList = ArrayList()
        init(view, context)

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }


    private fun init(view: View, context: Context) {
        mPager = view.findViewById(R.id.viewPager) as ViewPager
//        indicator = findViewById(R.id.indicator) as CircleIndicator
//        tvPager = findViewById(R.id.tvPager) as TextView
        circleIndicator = view.findViewById(R.id.circleIndicator)

    }

    fun setEvent() {
        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                val currentPager = position + 1
                currentPage = position
//                tvPager.text = "$currentPager/${imageModelArrayList!!.size}"
            }
        })
    }

    fun handelViewPager() {
        mPager.adapter = SlidingViewAdapter(context, this.imageModelArrayList!!)

        circleIndicator.setViewPager(mPager)
//        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius

        NUM_PAGES = imageModelArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mPager.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, TIME_DELAY, TIME_DELAY)

    }

    fun setListImageURL(listItem: ArrayList<Int>) {
        this.imageModelArrayList = listItem
        showNumberPager()
        handelViewPager()
        setEvent()
    }

    fun showNumberPager() {
//        if (imageModelArrayList!!.isEmpty() || this.imageModelArrayList!!.size < 2) {
//            tvPager.visibility = View.INVISIBLE
//
//        } else {
//            tvPager.visibility = View.VISIBLE
//            if (TextUtils.isEmpty(tvPager.text)) {
//                tvPager.text = "1/${imageModelArrayList!!.size}"
//            }
//        }
    }

}
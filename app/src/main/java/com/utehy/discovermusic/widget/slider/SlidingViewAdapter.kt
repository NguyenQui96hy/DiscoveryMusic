package com.utehy.discovermusic.widget.slider

import android.content.Context
import android.os.Parcelable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.joooonho.SelectableRoundedImageView
import com.utehy.discovermusic.R
import java.util.*


class SlidingViewAdapter(private val context: Context, private val listImageURL: ArrayList<Int>) : PagerAdapter() {
    private val inflater: LayoutInflater


    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return listImageURL.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.item_sliding_view_addapter, view, false)!!

        val imageView = imageLayout
                .findViewById(R.id.image) as ImageView
        val imageChild = imageLayout
                .findViewById(R.id.imageSong) as SelectableRoundedImageView

        imageView.setImageResource(listImageURL[position])
        imageChild.setImageResource(listImageURL[position])

//        val bitmap = BitmapFactory.decodeResource(context.resources,listImageURL[position])
//        val circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100)
//        imageChild.setImageBitmap(circularBitmap);

//        GlideApp.with(imageView)
//                .asBitmap()
//                .load(listImageURL[position])
//                .centerCrop()
//                .listener(object : RequestListener<Bitmap> {
//                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
//                        return true
//                    }
//
//                    override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
//                        imageView.setImageBitmap(resource)
//                        return true
//                    }
//
//                })
//                .into(imageView)
        view.addView(imageLayout, 0)
        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }
}
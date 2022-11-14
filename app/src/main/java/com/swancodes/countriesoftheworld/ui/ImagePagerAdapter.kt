package com.swancodes.countriesoftheworld.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.model.CountryBaseResponseItem

class ImagePagerAdapter(private val context: Context, private var imageList: List<CountryBaseResponseItem>?): PagerAdapter() {

    override fun getCount(): Int {
        return imageList?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.image_slider, null)

        val imageView: ImageView = view.findViewById(R.id.image_view)
        imageList?.get(position).let {
            Glide.with(context)
                .load(it)
                .into(imageView)
        }
        val viewPager = container as ViewPager2
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container:ViewGroup, position: Int, `object` : Any) {
        val viewPager = container as ViewPager2
        val view = `object` as View
        viewPager.removeView(view)
    }
}
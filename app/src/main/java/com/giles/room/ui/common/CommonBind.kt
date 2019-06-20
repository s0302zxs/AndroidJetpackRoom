package com.giles.room.ui.common

import android.databinding.BindingAdapter
import android.text.format.DateUtils
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giles.room.R
import timber.log.Timber
import java.util.*


object CommonBind{
    private const val AVERAGE_MONTH_IN_MILLIS = DateUtils.DAY_IN_MILLIS * 30

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, bannerUrl : String?) {
        Timber.d("imageUrl bannerUrl = $bannerUrl")

        val context = imageView.context

        Glide.with(context)
            .applyDefaultRequestOptions(RequestOptions().placeholder(com.giles.room.R.mipmap.ic_launcher))
            .load(bannerUrl)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("showText")
    fun bindText(textView: TextView, text : String?) {
        Timber.d("showText text = $text")
        textView.text = text
    }

    @JvmStatic
    @BindingAdapter("convertDate")
    fun convertDate(textView: TextView, timeStamp : Long?) {
        Timber.d("convertDate timeStamp = $timeStamp")
        if(timeStamp == null){
            return
        }

        val context = textView.context
        val timeMilli = timeStamp?.times(1000)
        val now = Date().time
        var delta = now - timeMilli!!
        val resolution: Long

        when {
            delta <= DateUtils.MINUTE_IN_MILLIS -> {
                resolution = DateUtils.SECOND_IN_MILLIS
                textView.text = DateUtils.getRelativeTimeSpanString(timeMilli, now, resolution).toString()

            }
            delta <= DateUtils.HOUR_IN_MILLIS -> {
                resolution = DateUtils.MINUTE_IN_MILLIS
                textView.text = DateUtils.getRelativeTimeSpanString(timeMilli, now, resolution).toString()

            }
            delta <= DateUtils.DAY_IN_MILLIS -> {
                resolution = DateUtils.HOUR_IN_MILLIS
                textView.text = DateUtils.getRelativeTimeSpanString(timeMilli, now, resolution).toString()
            }
            delta < DateUtils.WEEK_IN_MILLIS -> //days ago
                textView.text = (delta / DateUtils.DAY_IN_MILLIS).toString() + " " + context.getString(R.string.days_ago)
            delta < AVERAGE_MONTH_IN_MILLIS ->
                textView.text = (delta / DateUtils.WEEK_IN_MILLIS).toString() + " " + context.getString(R.string.weeks_ago)
            delta < DateUtils.YEAR_IN_MILLIS ->
                textView.text = (delta / AVERAGE_MONTH_IN_MILLIS).toString() + " " + context.getString(R.string.months_ago)
            else ->
                textView.text = (delta / DateUtils.YEAR_IN_MILLIS).toString() + " " + context.getString(R.string.years_ago)
        }

    }
}
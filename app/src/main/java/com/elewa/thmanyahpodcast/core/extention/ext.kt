package com.elewa.thmanyahpodcast.core.extention

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import java.lang.ref.WeakReference
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.sql.DataSource


fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}
fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}
fun String.toDate(
    dateTimeFormat: String = "yyyy-MM-dd",
    languageCode:String="ar",
    timeZone: String = "UTC"
): Date? {
    val df = SimpleDateFormat(dateTimeFormat, Locale(languageCode))
    df.timeZone = TimeZone.getTimeZone(timeZone)
    return try {
        df.parse(this)
    } catch (e: ParseException) {
        null
    }

}

fun Date.toFormattedString(): String {
    val yearFormat = SimpleDateFormat("yyyy", Locale("en"))
    val monthFormat = SimpleDateFormat("MMMM", Locale("ar"))
    return "${monthFormat.format(this)} ${yearFormat.format(this)} "
}

package com.example.gamesystest.presentation.extensions

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun ImageView.loadImage(image: Any?, placeholder: Int = 0, circular: Boolean = false) {
    Glide.with(context).load(image).placeholder(placeholder).apply(
            if (circular) {
                RequestOptions.circleCropTransform()
            } else {
                RequestOptions.noTransformation()
            }
        ).into(this)
}

fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layout, this, attachToRoot)
}

fun ImageView.displayImage(name: String, context: Context) {

    val drawableName = if (name == "do") "do_" else name

    val packageName :String = context.applicationContext.packageName
    val imgId: Int = resources.getIdentifier(drawableName, "drawable", packageName)
    this.setImageResource(imgId)
}

fun Context.toastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG ).show()
}

fun listToString(field: List<String>): String {

    var convertedString = " "

    field.forEachIndexed { index, _ ->
        convertedString += field[index].toString().plus(", ")
    }
    return convertedString.trim()
}


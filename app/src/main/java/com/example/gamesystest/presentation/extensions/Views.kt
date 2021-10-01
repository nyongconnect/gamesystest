package com.example.gamesystest.presentation.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
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
        if(index < field.size - 1)
            convertedString += field[index].plus(", ")
        else convertedString += field[index]
    }
    return convertedString.trim()
}


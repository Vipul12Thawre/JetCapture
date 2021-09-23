package com.vips.jetcapture.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View

class ImageUtils {

    companion object{
        fun generateShareImage(view: View): Bitmap {
            val b = Bitmap.createBitmap(
                view.width,
                view.height,
                Bitmap.Config.ARGB_8888
            )
            val c = Canvas(b)
            view.layout(
                view.left,
                view.top,
                view.right,
                view.bottom
            )
            view.draw(c)
            return b
        }
    }
}
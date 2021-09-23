package com.vips.jetcapture.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception

class ShareUtils {

    companion object{
        fun saveBitmapAndGetUri(context: Context, bitmap: Bitmap): Uri? {
            val path: String = context.externalCacheDir.toString() + "/testImg.jpg"
            var out: OutputStream? = null
            val file = File(path)
            try {
                out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                out.flush()
                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return FileProvider.getUriForFile(
                context, context.packageName + ".com.vips.jetcapture.provider", file
            )
        }

        fun shareImageToOthers(context: Context, text: String?, bitmap: Bitmap?) {
            val imageUri: Uri? = bitmap?.let { saveBitmapAndGetUri(context, it) }
            val chooserIntent = Intent(Intent.ACTION_SEND)
            chooserIntent.type = "image/*"
            chooserIntent.putExtra(Intent.EXTRA_TEXT, text)
            chooserIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
            chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            try {
                context.startActivity(chooserIntent)
            } catch (ex: Exception) {
            }
        }
    }
}
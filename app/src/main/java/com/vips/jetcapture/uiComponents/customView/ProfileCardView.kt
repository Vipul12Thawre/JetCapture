package com.vips.jetcapture.uiComponents.customView

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView
import com.vips.jetcapture.uiComponents.ProfileCard
import com.vips.jetcapture.utils.ImageUtils
import com.vips.jetcapture.utils.ShareUtils

class ProfileCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
      ProfileCard()
    }

    fun capture(view: ProfileCardView) {
        val bitmap = ImageUtils.generateShareImage(view)
        ShareUtils.shareImageToOthers(context,"test", bitmap)
    }

}
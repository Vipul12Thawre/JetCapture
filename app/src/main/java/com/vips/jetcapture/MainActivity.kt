package com.vips.jetcapture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.vips.jetcapture.uiComponents.customView.ProfileCardView
import com.vips.jetcapture.ui.theme.JetCaptureTheme

class MainActivity : ComponentActivity() {

    private var jetCaptureView: MutableState<ProfileCardView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCaptureTheme {
                BuildUI()
            }
        }
    }

    @Composable
    private fun BuildUI() {
        Surface(
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier.fillMaxSize()
        ) {

            Scaffold(

                bottomBar = {
                    BottomAppBar(
                        elevation = 10.dp,
                        cutoutShape = RoundedCornerShape(18.dp),
                        backgroundColor = MaterialTheme.colors.secondary
                    ) {

                    }
                },
                floatingActionButton = {
                    ExtendedFloatingActionButton({
                        Text(text = "Capture ProfileView", color = Color.White)
                    },
                        onClick = {
                            jetCaptureView?.value?.capture(jetCaptureView?.value as ProfileCardView)
                        },
                        shape = RoundedCornerShape(18.dp),
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_camera_alt_24),
                                contentDescription = null
                            )
                        }
                    )
                },
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.Center,
                backgroundColor = MaterialTheme.colors.primaryVariant

            ) {

                jetCaptureView = remember { mutableStateOf(ProfileCardView(this@MainActivity)) }
                Box(modifier = Modifier.fillMaxSize()) {
                    AndroidView(
                        modifier = Modifier
                            .wrapContentSize(),
                        factory = {
                            ProfileCardView(
                                it
                            ).apply {

                                post {
                                    jetCaptureView?.value = this
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
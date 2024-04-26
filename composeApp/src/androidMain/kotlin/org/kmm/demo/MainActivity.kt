package org.kmm.demo

import common.presentation.app.App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
//            this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
//            this.window.navigationBarColor =
//                ContextCompat.getColor(this, android.R.color.transparent)
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
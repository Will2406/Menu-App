package com.android.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.android.menu.screen.login.InitLoginScreen
import com.android.menu.ui.theme.MenuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MenuTheme {
                InitLoginScreen(context = LocalContext.current)
            }
        }
    }
}
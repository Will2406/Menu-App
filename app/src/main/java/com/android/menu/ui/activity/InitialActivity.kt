package com.android.menu.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.menu.screen.login.InitLoginScreen
import com.android.menu.ui.activity.InitialViewModel
import com.android.menu.ui.theme.MenuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialActivity : ComponentActivity() {

    private val viewModel: InitialViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.viewState.value.isSplashLoading
            }
        }

        setContent {
            MenuTheme {

                val state = viewModel.viewState.collectAsState().value
                when {
                    !state.isLoginSuccessful -> {
                        InitLoginScreen(context = LocalContext.current)
                    }
                    state.isLoginSuccessful -> {
                        LocalContext.current.startActivity(Intent(LocalContext.current, MainActivity::class.java))
                        (LocalContext.current as Activity).finish()

                    }
                }
            }
        }
    }
}
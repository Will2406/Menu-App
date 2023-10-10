package com.android.menu.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.android.menu.activity.MainActivity
import com.android.menu.navigation.initial.InitialNavigation
import com.android.menu.navigation.main.MainNavigation
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

            val navController = rememberNavController()
            val state = viewModel.viewState.collectAsState().value

            when {
                state.isLoginSuccessful -> {
                    LocalContext.current.startActivity(Intent(LocalContext.current, MainActivity::class.java))
                    (LocalContext.current as Activity).finish()

                }
            }

            MenuTheme {
                Scaffold { padding ->
                    Column(
                        modifier = androidx.compose.ui.Modifier
                            .padding(padding)
                    ) {
                        InitialNavigation(navController = navController)
                    }
                }
            }
        }
    }
}
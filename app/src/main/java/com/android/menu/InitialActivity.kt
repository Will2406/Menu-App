package com.android.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.android.menu.navigation.BottomNavigationBar
import com.android.menu.navigation.Navigation
import com.android.menu.screen.login.LoginScreen
import com.android.menu.ui.theme.MenuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            MenuTheme {
                val navController = rememberNavController()
                LoginScreen() {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            }
        }
    }
}
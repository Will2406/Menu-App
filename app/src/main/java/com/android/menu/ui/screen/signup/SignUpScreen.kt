package com.android.menu.ui.screen.signup

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.menu.HtmlText
import com.android.menu.navigation.initial.InitialRoute
import com.android.menu.screen.login.LoginViewModel


@Composable
fun InitSignUpScreen(context: Context, navController: NavController) {

    val loginViewModel: LoginViewModel = hiltViewModel()

    SignUpScreen(
        navController = navController
    )
}


@Composable
fun SignUpScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 12.dp)
        ) {
            Text(
                text = "Already have account? ",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall,
            )
            Text(
                text = "Log In",
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFFFE3F19),
                modifier = Modifier.clickable { navController.popBackStack() }
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = name,
            placeholder = {
                Text(
                    text = "Name*",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            onValueChange = { name = it },
            textStyle = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = lastName,
            placeholder = {
                Text(
                    text = "Last Name*",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            onValueChange = { lastName = it },
            textStyle = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = email,
            placeholder = {
                Text(
                    text = "Email*",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = password,
            placeholder = {
                Text(
                    text = "Password (8+ characters)",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            textStyle = MaterialTheme.typography.bodySmall,
            onValueChange = { password = it },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }, trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            Icons.Filled.Visibility, ""
                        )
                    }
                } else {
                    IconButton(onClick = { showPassword = true }) {
                        Icon(
                            Icons.Filled.VisibilityOff, ""
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFFE3F19)
                )
            )
            HtmlText(
                text = "By creating an account you have to agree with our <b>Terms and Conditions</b>",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE3F19))
        ) {
            Text(
                text = "Sign Up Now",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    MaterialTheme {
        //SignUpScreen(navControlle)
    }
}
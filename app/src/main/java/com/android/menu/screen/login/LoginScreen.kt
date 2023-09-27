package com.android.menu.screen.login

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.menu.MainActivity
import com.android.menu.R

@Composable
fun LoginScreen(context: Context) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (headerRef, bodyRef, bottomRef) = createRefs()
        var emailText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }

        var showPassword by remember { mutableStateOf(false) }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(headerRef) {
                    linkTo(top = parent.top, bottom = parent.bottom, bias = 0.2f)
                    linkTo(start = parent.start, end = parent.end)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logotype),
                contentDescription = "",
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "Hi, welcome back!",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 24.sp
            )

            Text(
                text = "Login in to your account",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 18.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .constrainAs(bodyRef) {
                    top.linkTo(headerRef.bottom, margin = 24.dp)
                    linkTo(start = parent.start, end = parent.end)
                })
        {

            OutlinedTextField(
                value = emailText,
                leadingIcon = {
                    Icon(Icons.Filled.Email, "")
                },
                onValueChange = { emailText = it },
                textStyle = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = passwordText,
                leadingIcon = {
                    Icon(Icons.Filled.Password, "")
                },
                textStyle = MaterialTheme.typography.bodySmall,
                onValueChange = { passwordText = it },
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
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot password?",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },

                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE3F19))
            ) {
                Text(
                    text = "Log In",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )

            }

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(54.dp)
                        .padding(top = 18.dp)
                        .fillMaxWidth()
                ) {
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "or login with ",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1.4f)
                    )
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .constrainAs(bottomRef) {
                    bottom.linkTo(parent.bottom)
                    linkTo(start = parent.start, end = parent.end)
                }
        ) {
            Text(text = "Don't have account?  ")
            Text(text = "Sign Up")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(context = LocalContext.current)
    }
}
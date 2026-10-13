package com.example.androidstudioipt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidstudioipt.ui.theme.AndroidStudioIptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudioIptTheme {
                Scaffold(
                    containerColor = Color.White,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Surface(
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        LoginScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var emailOrUsername by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(horizontal = 28.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top and Middle content container
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f, fill = false)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Hashtag Logo
            HashtagLogo(
                modifier = Modifier
                    .size(90.dp)
                    .padding(bottom = 24.dp)
            )

            // Header Title
            Text(
                text = "#WelcomeBack",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A00E5),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Login to explore trending #tags",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(36.dp))

            // Email or Username Input Field
            OutlinedTextField(
                value = emailOrUsername,
                onValueChange = { emailOrUsername = it },
                placeholder = { Text("Email or #username", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Email or Username Icon",
                        tint = Color.Gray
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF5A00E5),
                    unfocusedBorderColor = Color(0xFFBDBDBD)
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Password Icon",
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                            tint = Color.Gray
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF5A00E5),
                    unfocusedBorderColor = Color(0xFFBDBDBD)
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Login Button
            Button(
                onClick = { /* Handle Login action */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5A00E5)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password Link
            TextButton(onClick = { /* Handle Forgot Password */ }) {
                Text(
                    text = "Forgot Password?",
                    fontSize = 13.sp,
                    color = Color(0xFF5A00E5),
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Bottom Footer Link
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable { /* Handle Sign Up Navigation */ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                fontSize = 13.sp,
                color = Color.Gray
            )
            Text(
                text = "#SignUp",
                fontSize = 13.sp,
                color = Color(0xFF5A00E5),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun HashtagLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val strokeWidth = width * 0.16f

        val lightBlue = Color(0xFF1E88E5)
        val darkBlue = Color(0xFF0D47A1)

        // Top horizontal line (light blue)
        drawLine(
            color = lightBlue,
            start = androidx.compose.ui.geometry.Offset(width * 0.15f, height * 0.35f),
            end = androidx.compose.ui.geometry.Offset(width * 0.85f, height * 0.35f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )

        // Bottom horizontal line (dark blue)
        drawLine(
            color = darkBlue,
            start = androidx.compose.ui.geometry.Offset(width * 0.15f, height * 0.65f),
            end = androidx.compose.ui.geometry.Offset(width * 0.85f, height * 0.65f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )

        // Left vertical line (light blue)
        drawLine(
            color = lightBlue,
            start = androidx.compose.ui.geometry.Offset(width * 0.35f, height * 0.15f),
            end = androidx.compose.ui.geometry.Offset(width * 0.35f, height * 0.85f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )

        // Right vertical line (dark blue)
        drawLine(
            color = darkBlue,
            start = androidx.compose.ui.geometry.Offset(width * 0.65f, height * 0.15f),
            end = androidx.compose.ui.geometry.Offset(width * 0.65f, height * 0.85f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AndroidStudioIptTheme {
        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
            LoginScreen()
        }
    }
}

package com.unreal.zomatocl.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.unreal.zomatocl.R
import com.unreal.zomatocl.ui.theme.MainRed
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheScreen()
        }
        lifecycleScope.launch {
            delay(2000)
            startActivity(
                Intent(applicationContext, LoginScreen::class.java)
            )
        }
    }
}

@Composable
fun TheScreen() {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = MainRed),
        verticalArrangement = Arrangement.Center){
        Image(
            painter = painterResource(id = R.drawable.splashscreen_text),
            contentDescription = "this",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.earth_clipart),
            contentDescription = "this",
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        )

    }
}

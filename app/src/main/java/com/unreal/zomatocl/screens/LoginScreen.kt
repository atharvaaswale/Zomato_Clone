package com.unreal.zomatocl.screens

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.unreal.zomatocl.R
import com.unreal.zomatocl.ui.theme.BoldHeading
import com.unreal.zomatocl.ui.theme.DividerLine
import com.unreal.zomatocl.ui.theme.LightText
import com.unreal.zomatocl.ui.theme.White

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogScreen()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LogScreen() {
    var countryCode by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    Column {
        Image(painter = painterResource(id = R.drawable.loginscreen_cover),
            contentDescription = "login cover",
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth)
        Column (modifier = Modifier
            .fillMaxSize()
            .weight(6f)
            .padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(
                text = stringResource(R.string.loginscreen_heading),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = BoldHeading
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row (horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(color = DividerLine, thickness = 1.dp,
                    modifier = Modifier.weight(1f))
                Text(text = "Log in or Sign up",
                    color = LightText,
                        modifier = Modifier.padding(horizontal = 10.dp))
                HorizontalDivider(color = DividerLine, thickness = 1.dp,modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Card (shape = CardDefaults.outlinedShape,
                    colors = CardColors(White, White, White, White),
                    border = BorderStroke(2.dp, DividerLine),
                    modifier = Modifier
                        .width(70.dp)
                        .height(46.dp)
                        .align(Alignment.CenterVertically)) {
                    Row (horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically){
                        CountryPicker (defaultCountryCode = "in", onCountrySelected = {
                            countryCode = it.countryPhoneNumberCode
                            Log.d("1212Test", "LogScreen: ${it.countryPhoneNumberCode}")
                        })

                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Card (shape = CardDefaults.outlinedShape,
                    colors = CardColors(White, White, White, White),
                    border = BorderStroke(2.dp, DividerLine),
                    modifier = Modifier
                        .width(70.dp)
                        .height(46.dp)
                        .align(Alignment.CenterVertically)
                        .weight(1f)) {
                    Row (verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = countryCode, fontSize = 14.sp, color = BoldHeading)
                        Spacer(modifier = Modifier.width(10.dp))
                        TextField(value = phone, onValueChange = {
                            phone = it
                        }, colors = TextFieldDefaults.colors( unfocusedContainerColor = White ))
                    }

                }

            }
        }
    }

}


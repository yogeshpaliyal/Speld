package com.yogeshpaliyal.composeotpview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yogeshpaliyal.composeotpview.ui.theme.AndroidComposeOTPViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeOTPViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val text = remember { mutableStateOf("") }


                    Column(modifier = Modifier.fillMaxSize()) {
                        PinInput(value = text.value, obscureText = null) {
                            text.value = it
                        }
                    }


                }
            }
        }
    }
}
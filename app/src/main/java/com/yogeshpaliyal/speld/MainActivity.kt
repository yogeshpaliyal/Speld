package com.yogeshpaliyal.speld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yogeshpaliyal.speld.ui.theme.AndroidComposeOTPViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeOTPViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val text = remember { mutableStateOf("") }


                    Column(modifier = Modifier.fillMaxSize()) {

                        Spacer(modifier = Modifier.height(20.dp))

                        // Solid PIN View
                        PinInput(value = text.value, obscureText = null) {
                            text.value = it
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // Bordered PIN View
                        PinInput(
                            modifier = Modifier.border(
                                BorderStroke(2.dp, Color.Red),
                                shape = RoundedCornerShape(3.dp)
                            ), value = text.value,
                            obscureText = "*",
                            length = 6
                        ) {
                            text.value = it
                        }

                    }


                }
            }
        }
    }
}
package com.yogeshpaliyal.speld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                    val length = 5 // Define the length of the PIN here

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        Arrangement.Center, Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        // Solid PIN View
                        PinInput(value = text.value, obscureText = null) {
                            text.value = it
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // Bordered PIN View
                        PinInput(
                            cellModifier = Modifier
                                .size(width = 45.dp, height = 45.dp)
                                .clip(MaterialTheme.shapes.large)
                                .background(
                                    MaterialTheme.colors.primary.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(3.dp)
                                )
                                .border(
                                    BorderStroke(2.dp, Color.Red),
                                    shape = RoundedCornerShape(3.dp)
                                ),
                            value = text.value,
                            obscureText = "*",
                            length = length, //Use the number defined here
                            disableKeypad = true, //Do not open the android keypad
                        ) {
                            text.value = it
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        KeyPad(input = text, length)

                    }


                }
            }
        }
    }

    @Composable
    fun KeyPad(input: MutableState<String>, length: Int) {
        val callback = { text: String ->
            handleButtonClick(text, input, length)
        }

        Column(
            modifier = Modifier
                .padding(5.dp, 5.dp)
                .fillMaxWidth(0.5f)

        ) {
            NumKeypadRow(
                listOf("1", "2", "3"),
                listOf(0.33f, 0.33f, 0.33f),
                callback
            )
            NumKeypadRow(
                listOf("4", "5", "6"),
                listOf(0.33f, 0.33f, 0.33f),
                callback
            )
            NumKeypadRow(
                listOf("7", "8", "9"),
                listOf(0.33f, 0.33f, 0.33f),
                callback
            )
            NumKeypadRow(
                listOf("C", "0", "←"),
                listOf(0.33f, 0.33f, 0.33f),
                callback
            )
        }
    }

    @Composable
    fun NumKeypadRow(
        texts: List<String>,
        weights: List<Float>,
        callback: (text: String) -> Any
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp, 2.dp)
        ) {
            for (i in texts.indices) {
                val useIcon = texts[i] == "←"
                MyButton(
                    text = texts[i],
                    callback = callback,
                    modifier = Modifier
                        .weight(weights[i]),
                    useIcon,
                )
            }
        }
    }

    @Composable
    fun MyButton(
        text: String,
        callback: (text: String) -> Any,
        modifier: Modifier = Modifier,
        useIcon: Boolean = false
    ) {
        Button(
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.Black,

                ),
            onClick = {
                callback(text)
            },
            border = null,
            elevation = null,
            modifier = modifier
                .size(40.dp, 35.dp)
                .padding(2.dp, 0.dp)
        ) {
            if (useIcon) {
                if (text == "←") Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            } else Text(text)
        }
    }

    private fun handleButtonClick(
        txt: String,
        inputTextView: MutableState<String>,
        length: Int
    ) {
        when (txt) {
            "←" -> if (inputTextView.value.isNotEmpty()) {
                inputTextView.value = inputTextView.value.dropLast(1) // remove last char
            }

            "C" -> inputTextView.value = "" // clear all text
            else -> if (inputTextView.value.length < length) inputTextView.value += txt // handles key input here
        }
    }
}
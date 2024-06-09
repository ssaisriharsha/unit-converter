package com.ssaisriharsha.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ssaisriharsha.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    @Suppress("UNUSED_VARIABLE") val c = innerPadding
                    UnitConverter()
                }
            }
        }
    }
}


@Composable
fun UnitConverter() {
    // State Variables
    val select1State = remember {
        mutableStateOf("Select")
    }
    val dropDown1State = remember {
        mutableStateOf(false)
    }
    val select2State = remember {
        mutableStateOf("Select")
    }
    val dropDown2State = remember {
        mutableStateOf(false)
    }
    var input by remember {
        mutableStateOf("")
    }
    var resultText by remember {
        mutableStateOf("")
    }
    // State Controls
    val changeDropdownState: (MutableState<Boolean>) -> Unit = { state ->
        state.value = !state.value
    }
    val changeSelectState: (MutableState<String>, String) -> Unit = { state, str ->
        state.value = str
    }
    // Composable functions
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "Unit converter",
            fontWeight = FontWeight.Bold
        )
        SpaceElements()
        OutlinedTextField(
            value = input,
            onValueChange = {newValue ->
                input = newValue
                if(select1State.value == select2State.value || select1State.value == "Select" || select2State.value == "Select") {
                    resultText = "Invalid Conversion."
                }
                if(input != "") {
                    when (select1State.value) {
                        "Centimeter" -> when (select2State.value) {
                            "Meter" -> resultText = "${CmTo(input).m()}"
                            "Millimeter" -> resultText = "${CmTo(input).mm()}"
                            "Kilometer" -> resultText = "${CmTo(input).km()}"
                        }

                        "Meter" -> when (select2State.value) {
                            "Centimeter" -> resultText = "${MTo(input).cm()}"
                            "Millimeter" -> resultText = "${MTo(input).mm()}"
                            "Kilometer" -> resultText = "${MTo(input).km()}"
                        }

                        "Millimeter" -> when (select2State.value) {
                            "Meter" -> resultText = "${MmTo(input).m()}"
                            "Centimeter" -> resultText = "${MmTo(input).cm()}"
                            "Kilometer" -> resultText = "${MmTo(input).km()}"
                        }

                        "Kilometer" -> when (select2State.value) {
                            "Meter" -> resultText = "${KmTo(input).m()}"
                            "Centimeter" -> resultText = "${KmTo(input).cm()}"
                            "Millimeter" -> resultText = "${KmTo(input).mm()}"
                        }
                    }
                }
                else {
                    resultText = "${0}"
                }
            },
            placeholder = {Text("Enter Value")},
            label = { Text("Value")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        SpaceElements()
        Row {
            Box {
                Button(
                    onClick = {
                        changeDropdownState(dropDown1State)
                    }
                ) {
                    Text(text = select1State.value)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
            DropdownMenu(expanded = dropDown1State.value, onDismissRequest = {changeDropdownState(dropDown1State)}) {
                DropdownMenuItem(
                    text = {Text("Centimeter")},
                    onClick = {
                        changeSelectState(select1State, "Centimeter")
                        changeDropdownState(dropDown1State)
                    }
                )
                DropdownMenuItem(
                    text = { Text("Meter") },
                    onClick = {
                        changeSelectState(select1State, "Meter")
                        changeDropdownState(dropDown1State)
                    }
                )
                DropdownMenuItem(
                    text = { Text("Millimeter")},
                    onClick = {
                        changeSelectState(select1State, "Millimeter")
                        changeDropdownState(dropDown1State)
                    }
                )
                DropdownMenuItem(
                    text = { Text("Kilometer") },
                    onClick = {
                        changeSelectState(select1State, "Kilometer")
                        changeDropdownState(dropDown1State)
                    }
                )
            }
            Spacer(modifier=Modifier.width(16.dp))
            Box {
                Button (
                    onClick = {
                        changeDropdownState(dropDown2State)
                    }
                ) {
                    Text(text = select2State.value)
                    Icon(imageVector=Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded=dropDown2State.value,
                    onDismissRequest={changeDropdownState(dropDown2State)}
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            changeSelectState(select2State, "Centimeter")
                            changeDropdownState(dropDown2State)
                        }
                    )
                    DropdownMenuItem(
                        text= {Text("Meter")},
                        onClick = {
                            changeSelectState(select2State, "Meter")
                            changeDropdownState(dropDown2State)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            changeSelectState(select2State, "Millimeter")
                            changeDropdownState(dropDown2State)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Kilometer") },
                        onClick = {
                            changeSelectState(select2State, "Kilometer")
                            changeDropdownState(dropDown2State)
                        }
                    )
                }
            }
        }
        SpaceElements()
        Text(
            text="Result: $resultText",
            fontWeight= FontWeight.Bold,
            textAlign= TextAlign.Center,
        )
    }
}

@Composable
fun SpaceElements(height: Dp = 16.dp) {
    Spacer(modifier=Modifier.height(height))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    UnitConverterTheme {
        UnitConverter()
    }
}

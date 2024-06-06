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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
                    val c = innerPadding
                    UnitConverter()
                }
            }
        }
    }
}


@Composable
fun UnitConverter() {
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "Unit converter",
            // modifier = modifier,
            fontWeight = FontWeight.Bold
        )
        SpaceElements()
        OutlinedTextField(
            value = "",
            onValueChange = {},
            // modifier=modifier,
            placeholder = {Text("Enter Value")},
            label = { Text("Value")},
            singleLine = true
        )
        SpaceElements()
        Row {
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
            DropdownMenu(expanded = false, onDismissRequest = {}) {
                DropdownMenuItem(text = {Text("Item 1")}, onClick = { /*TODO*/ })
            }
            Spacer(modifier=Modifier.width(16.dp))
            Box {
                Button (onClick = {}) {
                    Text("Select")
                    Icon(imageVector=Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
        }
        SpaceElements()
        Text(
            text="Result: ",
            fontWeight= FontWeight.Bold,
            textAlign= TextAlign.Center,
            // modifier= modifier
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

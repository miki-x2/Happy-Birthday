package com.example.happybirthday

// UI Hierarchy
// UI hierarchy is based onn containment
// One component can contain one or more components and the terms
// parent and child are used
// The parent UI elements contain children UI elements, which in turn
// can contain children UI elements
//
// Column, Row, and Box are composable functions that take composable content as arguments
// Can place items inside layout elements
//
// Trailing Lambda Syntax: Use curly braces instead of parentheses
//
// fun name ( parameter1, parameter2, ... function ){ body }
// When a function is passed as a parameter, trailing lambda syntax can be used
// Instead of putting function body along with the function name within the parentheses {}
// put the parentheses along with the function body after function name
// Ex:
// Row(
//      content = {
//          Text("Some text")
//          Text("Some more text")
//          Text("Last text")
//       }
// )
//
// Remove the content parameter and parentheses:
// Row{
//      Text("Some text")
//      Text("Some more text")
//      Text("Last text")
// }


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    // Need to pass the modifier parameter to the child elements in compostables
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            // scalable pixels (SP) is a unit of measure for the font size
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }

}

// Annotations can take parameters
// Parameters provide extra info to the tools processing them
// Can pass multiple parameters to the annotation
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
    }
}
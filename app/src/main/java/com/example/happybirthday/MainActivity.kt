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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

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
                    GreetingImage(message = getString(R.string.happy_birthday_text), from = getString(
                                            R.string.signature_text))
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
                .align(alignment = Alignment.CenterHorizontally)
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
        GreetingImage(stringResource(R.string.happy_birthday_text), stringResource(R.string.signature_text))
    }
}

// An R class is an automatically generated class by Android
// that contains the IDs of all resources in the project
// The resource ID is  the same as the filename
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    // painterResource() function loads a drawable image resource
    // and takes resource ID as an argument
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// Modifiers are used to decorate or add behavior to Jetpack Compose UI elements
// Can add backgrounds, padding or behavior to rows, text, or buttons
// To set them, a composable or a layout needs to accept a modifer as a parameter
//
// Ex: Changing background color to green
// Text(
//      text = "Hello World!",
//      // Solid element background color
//      modifier = Modifier.background(color = Color.Green)
// )
//
// Add Modifiers to layouts to position the child elements using arrangement and alignment properties
// To set children's position within a Row, set the horizontalArrangement and verticalAlignment
// For column, set verticalArrangement and horizontalAlignment
//
// Arrangment property is used to arrange the child elements when the size of layout
// is larger than the sum of its children
//
//

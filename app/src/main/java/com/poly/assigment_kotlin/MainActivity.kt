package com.poly.assigment_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.poly.assigment_kotlin.component.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}



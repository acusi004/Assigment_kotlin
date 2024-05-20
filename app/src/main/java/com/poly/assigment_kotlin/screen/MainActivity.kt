package com.poly.assigment_kotlin.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poly.assigment_kotlin.ui.theme.Assigment_kotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NavHost(
                navController = navController ,
                startDestination = "ManHinhChao",
                builder =  {
                    composable("ManHinhChao",){
                        ManHinhChao(navController)
                    }
                    composable("DangNhap",){
                        DangNhap(navController)
                    }
                    composable("DangKy",){
                        DangKy(navController)
                    }
                    composable("ManHinhChinh",){
                        ManHinhChinh(navController)
                    }
                    composable("Detail",){
                        Detail(navController)
                    }

                } )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}



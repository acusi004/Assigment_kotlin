package com.poly.assigment_kotlin.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.poly.assigment_kotlin.R
import com.poly.assigment_kotlin.ui.theme.fontFamily
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans

@Composable
fun ManHinhChao(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Box(
            Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.bg_manhinhchao),
                    contentScale = ContentScale.FillBounds
                ),

            ){
            Column(
                Modifier
                    .fillMaxSize()
                    .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,

                ) {

                text(text = "MAKE YOUR \nHOME BEAUTIFUL ")

                textSmall(text = "The best simple place where you discover most wonderful furnitures and make your home beautiful")

                Button(
                    modifier = Modifier
                        .width(159.dp)
                        .height(54.dp)

                    ,onClick = {
                        navController.navigate("login"){
                            popUpTo("Welcome"){inclusive =true}
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "GET STARTED", fontFamily = fontFamily)
                }
            }
        }


    }
}

@Composable
fun text(text:String){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text =text, fontSize = 30.sp, fontWeight = FontWeight.Bold , fontFamily = fontFamily)
    }
}
@Composable
fun textSmall(text:String){
    Column(
        Modifier
            .width(300.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text =text, fontSize = 18.sp, fontFamily = fontNunitoSans, color = Color.Gray)
    }
}
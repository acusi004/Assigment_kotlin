package com.poly.assigment_kotlin.screen

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.poly.assigment_kotlin.R
import com.poly.assigment_kotlin.ui.theme.fontFamily
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans

@Composable
fun DangNhap(navController: NavController){
    Column(
        Modifier
            .fillMaxSize(),


        ) {
        header()
        Title2(title = "Hello !")
        Title1(title = "WELCOME BACK")
        Spacer(modifier = Modifier.padding(0.dp, 20.dp))
        Form(navController)

    }
}
@Composable
fun header(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(100.dp)
        ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,

    ){


        Box(
            modifier = Modifier
                .size(width = 105.dp, height = 1.dp)
                .background(Color.Gray)

        )

        Box(
          modifier = Modifier
              .border(1.dp, Color.Gray, CircleShape)
              .clip(CircleShape)
              .size(60.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.sofa) ,
                contentDescription ="sofa",
                modifier = Modifier
                    .width(40.dp)
                    .height(30.dp)
                    .align(Alignment.Center)


            )
        }
        Box(
            modifier = Modifier
                .size(width = 105.dp, height = 1.dp)
                .background(Color.Gray)



        )
    }

}

@Composable
fun Title1(title: String){
    Column (
        modifier = Modifier

            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        Text(text = title, fontFamily = fontFamily, fontSize = 37.sp, fontWeight = FontWeight.Bold)
    }
}
@Composable
fun Title2(title: String){
    Column (
        modifier = Modifier

            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        Text(text = title, fontFamily = fontFamily, fontSize = 37.sp, color = Color.Gray)
    }
}
@Composable
fun Form(navController: NavController){
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(1.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(460.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()

                ,
                horizontalAlignment = Alignment.CenterHorizontally,

                ){
                var email by remember { mutableStateOf("Hello") }
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    label = { Text(text = "Email",  fontFamily = fontNunitoSans)},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        focusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )

                var password by remember { mutableStateOf("Hello") }
                TextField(
                    value = password,
                    onValueChange = {password = it},
                    label = { Text(text = "Password",  fontFamily = fontNunitoSans)},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        focusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,

                        ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )

                Text(
                    text = "Forgot password",
                    fontSize = 20.sp,
                    fontFamily = fontNunitoSans
                )
                Spacer(modifier = Modifier.padding(0.dp, 30.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.80f)
                        .height(54.dp)


                    ,onClick = {
                        navController.navigate("ManHinhChinh")

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Log in", fontSize = 18.sp,  fontFamily = fontNunitoSans)
                }
                TextButton(
                    onClick = {
                        navController.navigate("Dangky")
                              },
                       colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        )
                    ) {
                    Text(
                        text = "SIGN UP",
                        fontSize = 20.sp,
                        fontFamily = fontNunitoSans,
                        modifier = Modifier
                            .padding(0.dp, 10.dp)
                    )
                }
            }

        }



}


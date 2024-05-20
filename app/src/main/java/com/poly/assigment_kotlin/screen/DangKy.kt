package com.poly.assigment_kotlin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.poly.assigment_kotlin.ui.theme.fontFamily
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans


@Composable
fun DangKy(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        header()
        Text(
            text = "WELCOME",
            fontFamily = fontFamily,
            fontSize = 37.sp,
            fontWeight = FontWeight.Bold,
           modifier =  Modifier.fillMaxWidth()
                .padding(26.dp, 0.dp, 0.dp,0.dp)

            )
        Spacer(modifier = Modifier.padding(0.dp,0.dp, 0.dp, 20.dp))
        formRegister(navController)
    }
}


@Composable
fun formRegister(navController: NavController){
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(1.dp),
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(600.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

            ,
            horizontalAlignment = Alignment.CenterHorizontally,

            ){

            var name by remember { mutableStateOf("") }
            TextField(
                value = name,
                onValueChange = {name = it},
                label = { Text(text = "Name",  fontFamily = fontNunitoSans)},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    focusedLabelColor = Color.Black,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
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

            var password by remember { mutableStateOf("") }
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

            var Cfpassword by remember { mutableStateOf("") }
            TextField(
                value = Cfpassword,
                onValueChange = {Cfpassword = it},
                label = { Text(text = "Confirm Password",  fontFamily = fontNunitoSans)},
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

            
            Spacer(modifier = Modifier.padding(0.dp, 30.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.80f)
                    .height(54.dp)


                ,onClick = {
                    navController.navigate("dangNhap")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "SIGN UP", fontSize = 18.sp,  fontFamily = fontNunitoSans)
            }
            Row (

            ){
                Text(
                    text = "Already have account?",
                    color = Color.Gray,
                    fontFamily = fontNunitoSans,
                    modifier = Modifier
                        .padding(0.dp, 10.dp,8.dp)
                )

                Text(
                    text = "SIGN IN",
                    color = Color.Black,
                    fontFamily = fontNunitoSans,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(0.dp, 10.dp)
                )
            }
        }

    }
}

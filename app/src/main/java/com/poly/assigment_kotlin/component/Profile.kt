package com.poly.assigment_kotlin.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.poly.assigment_kotlin.R
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans

@Composable
fun Profile(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        MyTopAppBarProfile()
        AccountScreenControl(navController)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarProfile(){
    CenterAlignedTopAppBar(
        title = {
            Column {

                titleTopBar1(text = "Profile")
            }
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(26.dp))
            }
        }, actions = {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription =null,
                    modifier = Modifier
                        .size(26.dp))
            }
        }
    )
}

//@Composable
//fun HeaderProfile(){
//    Row (
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(150.dp)
//            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
//
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.imageprofile),
//            contentDescription = null,
//            modifier = Modifier
//                .width(80.dp)
//                .height(80.dp)
//                .clip(RoundedCornerShape(80.dp)))
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(10.dp, 0.dp, 0.dp, 0.dp),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(text = "do trung hieu", fontFamily = fontNunitoSans, fontWeight = FontWeight.Bold, fontSize = 22.sp)
//            Text(text ="dotrunghieu7490@gmail.com", fontFamily = fontNunitoSans, color = Color.Gray, fontSize = 17.sp)
//        }
//    }
//}

@Composable
fun MethodAccount(title : String , message : String , click : () -> Unit){
    Row (modifier = Modifier
        .height(85.dp)
        .fillMaxWidth()
        .clickable(onClick = click)
        .shadow(elevation = 1.dp, shape = RoundedCornerShape(3.dp))
        .background(Color("#FFFFFF".toColorInt())),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Row ( modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Column (modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly){
                Text(text = title, fontSize = 20.sp, fontWeight = FontWeight(700), fontFamily = fontNunitoSans)
                Text(text = message,fontSize = 15.sp, color = Color.Gray)
            }
            Image(painter = painterResource(id = R.drawable.back), contentDescription = null,
                modifier = Modifier.size(24.dp))
        }
    }
}

@Composable
fun AccountScreenControl( navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        ){
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.imageprofile), contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(RoundedCornerShape(80.dp)))
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = "Do trung hieu", fontSize = 22.sp, fontWeight = FontWeight(700), fontFamily = fontNunitoSans)
                    Text(text = "hieudtph35761@fpt.edu.vn", fontSize = 15.sp, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column {
//
                MethodAccount(
                    title = "My orders",
                    message = "Already have 10 orders",
                    click = { navController.navigate("order") })
                Spacer(modifier = Modifier.height(10.dp))
                MethodAccount(
                    title = "Shipping Addresses",
                    message = "03 Addresses",
                    click = { navController.navigate("selectShipment") })
                Spacer(modifier = Modifier.height(10.dp))
                MethodAccount(
                    title = "Payment Method",
                    message = "You have 2 cards",
                    click = { navController.navigate("paymentMethod") })
                Spacer(modifier = Modifier.height(10.dp))
                MethodAccount(
                    title = "My reviews",
                    message = "Reviews for 5 items",
                    click = { navController.navigate("myReview") })
                Spacer(modifier = Modifier.height(10.dp))
                MethodAccount(
                    title = "Setting",
                    message = "Notification, Password, FAQ, Contact",
                    click = { navController.navigate("setting") })
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

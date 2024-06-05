package com.poly.assigment_kotlin.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        HeaderProfile()
        Scaffold { innerPadding ->
            NoteApp(paddingValues = innerPadding)
        }
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

@Composable
fun HeaderProfile(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(
            painter = painterResource(id = R.drawable.imageprofile),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(80.dp)))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 0.dp, 0.dp, 0.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "do trung hieu", fontFamily = fontNunitoSans, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text ="dotrunghieu7490@gmail.com", fontFamily = fontNunitoSans, color = Color.Gray, fontSize = 17.sp)
        }
    }
}

@Composable
fun NoteApp(paddingValues: PaddingValues){
    val notes = listOf("My Order", "Shipping Addresses", "Payment Method", "My reviews", "Setting")
    val notes2 = listOf("Already have 10 orders", "03 Addresses", "You have 2 cards", "Reviews for 5 items", "Notification, Password, FAQ, Contact")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        notes.forEach{note -> ProfileCard(noteText = note) }


    }
}
@Composable
fun ProfileCard(noteText: String){
    Card(
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(9.dp),


    ){
        Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = noteText,
                    fontFamily = fontNunitoSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(26.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Expand Note",
                modifier = Modifier
                    .padding(26.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
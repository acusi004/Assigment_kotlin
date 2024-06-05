package com.poly.assigment_kotlin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poly.assigment_kotlin.R

@Composable
fun Notification(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        MyTopAppBarNotification()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarNotification(){
    CenterAlignedTopAppBar(
        title = {
            Column {

                titleTopBar1(text = "Notification")
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
        }
    )
}
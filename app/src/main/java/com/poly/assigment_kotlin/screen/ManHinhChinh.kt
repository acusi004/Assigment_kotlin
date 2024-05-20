package com.poly.assigment_kotlin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.poly.assigment_kotlin.R

import com.poly.assigment_kotlin.ui.theme.WhiteO

@Composable
fun ManHinhChinh(navController: NavController){
    Column {

        MyBottomAppBar()
    }
}
@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(
            Icons.Default.Home
        )
    }

   Scaffold (
        bottomBar = {

                BottomAppBar(
                    containerColor = WhiteO
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Screen.Home.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            modifier = Modifier
                                .size(26.dp),
                            tint = if(selected.value == Icons.Default.Home) Color.LightGray else Color.DarkGray
                        )
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.FavoriteBorder
                            navigationController.navigate(Screen.Favorites.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.wishlist),
                            contentDescription = "Search",
                            modifier = Modifier
                                .size(26.dp),
                            tint = if(selected.value == Icons.Default.FavoriteBorder) Color.LightGray else Color.DarkGray
                        )
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Notifications
                            navigationController.navigate(Screen.Notification.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bell),
                            contentDescription = "Home",
                            modifier = Modifier
                                .size(26.dp),
                            tint = if(selected.value == Icons.Default.Notifications) Color.LightGray else Color.DarkGray
                        )
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Screen.Profile.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Home",
                            modifier = Modifier
                                .size(26.dp),
                            tint = if(selected.value == Icons.Default.Person) Color.LightGray else Color.DarkGray
                        )
                    }
                }

        }
   ){paddingValues ->
       val navController = rememberNavController()
        NavHost(navController = navigationController,
            startDestination = Screen.Home.screen,
            modifier = Modifier.padding(paddingValues)
            
        ){

            composable(Screen.Home.screen){Home(navController)}
            composable(Screen.Favorites.screen){ Favorites() }
            composable(Screen.Notification.screen){ Notification() }
            composable(Screen.Profile.screen){ Profile() }

        }
   }



}
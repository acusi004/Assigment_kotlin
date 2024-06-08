package com.poly.assigment_kotlin.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.poly.assigment_kotlin.R
import com.poly.assigment_kotlin.ViewModel.InteriorViewModel
import com.poly.assigment_kotlin.ui.theme.fontFamily
import com.poly.assigment_kotlin.ui.theme.xam
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.poly.assigment_kotlin.Model.Interior
import com.poly.assigment_kotlin.ui.theme.WhiteO
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans
import com.poly.assigment_kotlin.ui.theme.xamDam
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

enum class ROUTE_HOME_SCREEN {
    Home,
    Favorite,
    Notification,
    Profile
}
data class BottomNavigationItem(
    val title: String,
    val selectIcon: ImageVector,
    var unselectItem: ImageVector
)
@Composable
fun Home(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        MyTopAppBar()
        Categories()
        ListProduct(navController = navController)

    }
}

@Composable
fun NavigationGraph(navHostController : NavController, navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController,
        startDestination = ROUTE_HOME_SCREEN.Home.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(ROUTE_HOME_SCREEN.Home.name) { Home( navHostController) }
        composable(ROUTE_HOME_SCREEN.Favorite.name) { Favorites(navController) }
        composable(ROUTE_HOME_SCREEN.Notification.name) { Notification(navController) }
        composable(ROUTE_HOME_SCREEN.Profile.name) { Profile(navHostController) }
    }
}
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color("#ffffff".toColorInt())
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) item.selectIcon else item.unselectItem,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = android.R.color.black),
                    unselectedIconColor = Color.Gray
                )
            )
        }
    }
}
@Composable
fun BottomNavigationApp(navHostController : NavController) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(ROUTE_HOME_SCREEN.Home.name, Icons.Default.Home, Icons.Outlined.Home),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Favorite.name, Icons.Default.Favorite, Icons.Outlined.Favorite),
        BottomNavigationItem(
            "Notification",
            Icons.Default.Notifications,
            Icons.Outlined.Notifications
        ),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Profile.name, Icons.Default.Person, Icons.Outlined.Person)
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(

            bottomBar = {
                BottomNavigationBar(
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    onItemSelected = { index ->
                        selectedItemIndex = index
                        navController.navigate(items[index].title)
                    }
                )
            }
        ) { innerPadding ->
            NavigationGraph(navHostController = navHostController,navController = navController, innerPadding = innerPadding)
        }
    }
}

@Composable
fun titleTopBar1(text: String){
    Text(
        text = text,
        fontFamily = fontFamily,
        color = Color.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun titleTopBar2(text: String){
    Text(
        text = text,
        fontFamily = fontFamily,
        color = Color.Gray,
        fontSize = 18.sp,
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
                Column {
                    titleTopBar2(text = "Make Home")
                    titleTopBar1(text = "BEAUTIFUL")
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
                    painter = painterResource(id = R.drawable.trolley),
                    contentDescription =null,
                    modifier = Modifier
                        .size(26.dp))
            }
        }
    )
}
@Composable
fun Categories(){
    data class InteriorModel(val name: String, val image: Int)
    val interiorList = mutableListOf<InteriorModel>()

    interiorList.add(InteriorModel("Popular", R.drawable.star))
    interiorList.add(InteriorModel("Chair", R.drawable.chair))
    interiorList.add(InteriorModel("Table", R.drawable.side_table))
    interiorList.add(InteriorModel("Armchair", R.drawable.armchair))
    interiorList.add(InteriorModel("Bed", R.drawable.double_bed))
    interiorList.add(InteriorModel("Lamb", R.drawable.floor_lamp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            ,
        horizontalArrangement = Arrangement.spacedBy(9.dp)

    ) {
        items(interiorList){ item ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(50.dp))
                    .padding(8.dp)
                    ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .background(color = if (item.image == 0) Color.Black else xam)
                        .padding(8.dp),
                )
                Text(text = item.name)

            }
        }
    }
}

@Composable
fun ListProduct(interiorViewModel: InteriorViewModel = viewModel(), navController: NavController){
    val interior by interiorViewModel.interior.observeAsState(listOf())

    LaunchedEffect(Unit) {
        interiorViewModel.getInterior()
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        state = rememberLazyStaggeredGridState(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)

    ) {
        items(interior) {item ->
            InteriorItem(item = item, navController = navController)
        }

    }


}



@Composable
fun InteriorItem(item: Interior, navController: NavController){
    val iconColor = remember{ mutableStateOf(Color.Unspecified) }
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White),

    modifier = Modifier
        .width(157.dp)
        .height(270.dp)
        .clickable {
            val itemJson = Gson().toJson(item)
            val encodedJson = URLEncoder.encode(itemJson, StandardCharsets.UTF_8.toString())
            navController.navigate("detail/${encodedJson}")
        }
    ){
      Column(

      ) {
         Box(
             modifier = Modifier
                 .fillMaxWidth()
         ){
             AsyncImage(
                 model = item.image,
                 contentDescription = null,
                 contentScale = ContentScale.Crop ,
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(200.dp)
             )             
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(190.dp)
                   .padding(2.dp),
               horizontalAlignment = Alignment.End,
               verticalArrangement = Arrangement.SpaceBetween


           ){

               IconButton(
                   onClick = {

                   },
                  modifier = Modifier
                      .clip(RoundedCornerShape(50.dp))


               ){
                   Icon(
                       painter = painterResource(id = R.drawable.love),
                       tint = iconColor.value,
                       contentDescription = null,
                       modifier = Modifier
                           .size(20.dp)
                           .clickable {
                               if (!item.favorite) {
                                   Toast
                                       .makeText(
                                           context,
                                           "Đã thêm ${item.name} vào yêu thích",
                                           Toast.LENGTH_SHORT
                                       )
                                       .show()
                                   iconColor.value = Color.Red
                               } else {
                                   iconColor.value = Color.Black
                               }
                           })
               }
               IconButton(
                   onClick = {

                   },
                   modifier = Modifier

                       .clip(RoundedCornerShape(20))
                       .background(color = xamDam)
               ){
                   Icon(painter = painterResource(id = R.drawable.bag), contentDescription = null, modifier = Modifier.size(20.dp))
               }

           }
         }
          Text(
              text = item.name,
              fontFamily= fontNunitoSans,
              fontSize = 19.sp,
              color = Color.DarkGray,
             )

          Text(
              text = "$ ${item.price}",
              fontFamily= fontNunitoSans,
              fontSize = 19.sp,
              fontWeight = FontWeight.Bold,
              color = Color.Black )
      }
    }
}
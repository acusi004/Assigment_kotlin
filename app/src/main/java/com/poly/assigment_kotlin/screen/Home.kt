package com.poly.assigment_kotlin.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.poly.assigment_kotlin.Model.Interior
import com.poly.assigment_kotlin.ui.theme.fontNunitoSans
import com.poly.assigment_kotlin.ui.theme.xamDam


@Composable
fun Home(navController: NavController){



    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        MyTopAppBar()
        Categories()
        ListProduct()

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
fun ListProduct(interiorViewModel: InteriorViewModel = viewModel()){
    val interior by interiorViewModel.interior.observeAsState(listOf())
    val errorMessage by interiorViewModel.errorMessage.observeAsState("")

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
            interiorItem(item = item)
        }

    }


}



@Composable
fun interiorItem(item: Interior,){

    val navController = rememberNavController()
    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White),

    modifier = Modifier
        .width(157.dp)
        .height(270.dp)
        .clickable {

        }

    ){
      Column {
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
               val iconColor = remember{ mutableStateOf(Color.Unspecified) }
               IconButton(
                   onClick = {

                   },
                  modifier = Modifier
                      .clip(RoundedCornerShape(50.dp))


               ){
                   Icon(painter = painterResource(id = R.drawable.love), tint = iconColor.value, contentDescription = null, modifier = Modifier.size(20.dp).clickable { iconColor.value = Color.Red })
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
              text = "${item.name}",
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
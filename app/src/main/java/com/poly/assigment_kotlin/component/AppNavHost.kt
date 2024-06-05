package com.poly.assigment_kotlin.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

enum class ROUTE_NAME{
    welcome,
    login,
    home,
    signup,
    detail,
    cart,
    checkout,
    success,
    order,
    addShipment,
    addPayment,
    paymentMethod,
    setting,
    selectShipment,
    myReview,
    rating
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = ROUTE_NAME.welcome.name) {
        composable(ROUTE_NAME.welcome.name) { ManHinhChao(navController) }
        composable(ROUTE_NAME.login.name) { DangNhap(navController) }
        composable(ROUTE_NAME.home.name) { BottomNavigationApp(navController) }
        composable(ROUTE_NAME.signup.name) { DangKy(navController) }
        composable(ROUTE_NAME.detail.name) {
            Detail(navController)
        }
        composable(ROUTE_NAME.cart.name) { Cart(navController) }
        composable(ROUTE_NAME.checkout.name) { CheckOut(navController) }
        composable(ROUTE_NAME.success.name) { FinalCheckout(navController) }
        composable(ROUTE_NAME.order.name) { Order(navController) }
        composable(ROUTE_NAME.addShipment.name) { ShippingAddress(navController) }

    }
}
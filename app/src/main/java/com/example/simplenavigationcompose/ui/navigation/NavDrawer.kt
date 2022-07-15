package com.example.simplenavigationcompose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.simplenavigationcompose.R

@Composable
fun DrawerHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp)
        ,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(navController: NavHostController?, closeNavDrawer: () -> Unit) {
    Column {
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_home,
            text = NavRoute.Home.path,
            onItemClick = {
                navController?.navigate(NavRoute.Home.path)
                closeNavDrawer()
            }
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_search,
            text = NavRoute.Search.path,
            onItemClick = {
                navController?.navigate(NavRoute.Search.withArgs("liang moi"))
                closeNavDrawer()
            }
        )
    }
}

@Composable
private fun DrawerMenuItem(
    iconDrawableId: Int,
    text: String,
    onItemClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {onItemClick()}
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(iconDrawableId),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, )
    }
}

@Preview(showBackground = true)
@Composable
private fun DrawerHeaderPreview(){
    DrawerHeader()
}

@Preview(showBackground = true)
@Composable
private fun DrawerBodyPreview(){
    DrawerBody(navController = null, closeNavDrawer = {})
}

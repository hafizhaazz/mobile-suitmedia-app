package com.example.suitmediaapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.suitmediaapp.R

@Composable
fun FirstPage(
    navController: NavController
){
    Image(
        painter = painterResource(id = R.drawable.background_suitmedia),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var palindromeText by remember { mutableStateOf(TextFieldValue("")) }
    var isPalindrome by remember { mutableStateOf<Boolean?>(null) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .width(116.dp)
                .height(116.dp))
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(310.dp),
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Name", fontSize = 16.sp) },
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .width(310.dp),
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp),
            value = palindromeText,
            onValueChange = { palindromeText = it },
            label = { Text("Palindrome", fontSize = 16.sp) }
        )
        Button(
            onClick = {
                isPalindrome = palindromeText.text == palindromeText.text.reversed()
            },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(310.dp)
                .height(48.dp),
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp),
        ) {
            Text("CHECK")
        }

        isPalindrome?.let {
            Text(
                text = if (it) "It is a palindrome!" else "It is not a palindrome!",
                fontSize = 18.sp
            )
        }

        Button(onClick = { navController.navigate("second_screen/{selectedUserName}")},
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(310.dp)
                .height(48.dp),
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp),) {
            Text("NEXT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    FirstPage(navController)
}
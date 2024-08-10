package com.example.suitmediaapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.suitmediaapp.ui.component.topAppBar

@Composable
fun SecondPage(
    selectedUserName: String, navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        topAppBar(
            text = "Second Screen",
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Welcome", fontSize = 12.sp)
            Text(
                text = "John Doe",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(36.dp),
                contentAlignment = Alignment.Center // Menempatkan teks di tengah horizontal
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Menempatkan konten di tengah horizontal
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = selectedUserName.ifEmpty { "Selected User Name" },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 200.dp)
                    )
                    Button(onClick = {
                        navController.navigate("third_screen")
                    }, modifier = Modifier
                        .padding(bottom = 16.dp)
                        .width(310.dp)
                        .height(48.dp),
                        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp),) {
                        Text("Choose a User")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondPageWithoutNav() {
   val navController = rememberNavController()
    SecondPage(navController = navController, selectedUserName = "")
}


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.suitmediaapp.ui.component.topAppBar
import kotlinx.coroutines.launch

@Composable
fun ThirdPage(userService: UserService, navController: NavController) {
    val scope = rememberCoroutineScope()
    var users by remember { mutableStateOf<List<UserModel>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        loading = true
        users = userService.getAllUsers(1)
        loading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        topAppBar(text = "Third Page", navController = navController)
        if (loading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(users) { user ->
                    UserItem(user)
                }
            }
        }
    }
}

@Composable
fun UserItem(user: UserModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(user.avatar),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )
            Column {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserListScreen() {
    val navController = rememberNavController()
    ThirdPage(userService = UserService(), navController = navController)
}
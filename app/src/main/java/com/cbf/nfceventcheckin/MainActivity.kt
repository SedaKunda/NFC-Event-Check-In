package com.cbf.nfceventcheckin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cbf.nfceventcheckin.ui.theme.NFCEventCheckInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFCEventCheckInTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") { LoginScreen(navController) }
        composable("event_details_screen") { EventDetailsScreen(navController) }
        composable("check_in_result_screen") { CheckInResultScreen() }
//        composable("admin_screen") { AdminScreen(checkedInUsers) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val checkedInUsers = mutableListOf("John Doe", "Jane Smith", "Alice Johnson")
    NFCEventCheckInTheme {
        AdminScreen(checkedInUsers)
    }
}
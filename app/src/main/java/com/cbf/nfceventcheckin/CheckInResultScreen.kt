package com.cbf.nfceventcheckin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CheckInResultScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    navController.navigate("event_details_screen")
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_24),
                    contentDescription = "Check In Successful",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Check In Successful", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
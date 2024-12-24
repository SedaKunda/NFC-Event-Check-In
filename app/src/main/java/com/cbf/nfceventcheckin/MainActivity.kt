package com.cbf.nfceventcheckin

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cbf.nfceventcheckin.ui.theme.NFCEventCheckInTheme

class MainActivity : ComponentActivity() {
    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        setContent {
            NFCEventCheckInTheme {
                Navigation()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        enableNfcForegroundDispatch()
    }

    override fun onPause() {
        super.onPause()
        disableNfcForegroundDispatch()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        // todo
    }

    private fun handleNfcTag(tag: Tag) {
        Log.d("Main","log tag info ${tag.id}")
    }

    private fun enableNfcForegroundDispatch() {
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            val tag: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
            Log.d("Main", "NFC Tag detected")
            tag?.let {
                Log.d("Main", "NFC Tag discovered and handled.")
                handleNfcTag(it)
            }
        }
    }

    private fun disableNfcForegroundDispatch() {
        nfcAdapter?.disableForegroundDispatch(this)
    }
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") { LoginScreen(navController) }
        composable("event_details_screen") { EventDetailsScreen(navController) }
        composable("check_in_result_screen") { CheckInResultScreen(navController) }
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
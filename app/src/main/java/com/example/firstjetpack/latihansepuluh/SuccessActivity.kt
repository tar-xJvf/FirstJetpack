package com.example.firstjetpack.latihansepuluh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjetpack.latihansepuluh.ui.theme.FirstJetpackTheme

class SuccessActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val inputName = intent.getStringExtra("inputName") ?: ""
            val inputEmail = intent.getStringExtra("inputEmail") ?: ""

            SuccessScreen(inputName, inputEmail)
        }
    }
}

@Composable
fun SuccessScreen(inputName: String, inputEmail: String) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sukses register ke aplikasi",
            modifier = Modifier
                .padding(5.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {

              Text(text = "Name: $inputName | ")
              Text(text = " Email: $inputEmail")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSuccessScreen() {
    FirstJetpackTheme {
        SuccessScreen(inputName = "JohnDoe", inputEmail = "john.doe@e")
    }

}
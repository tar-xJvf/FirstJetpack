package com.example.firstjetpack.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjetpack.navigation.ui.theme.FirstJetpackTheme


@Composable
fun DetailScreen(name:String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Detail Screen")
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Hello $name")


    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    FirstJetpackTheme {
        DetailScreen(name = "Preview Name")
    }
}
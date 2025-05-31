package com.example.firstjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjetpack.ui.theme.FirstJetpackTheme

class CardnameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Latihan1(ProfileUser("Budi", "20", "budi@example.com"))
            ProdukScreen()

        }
    }

}

data class Produk(
    val name: String,
    val price: String,
)


data class ProfileUser(
    val name: String,
    val age: String,
    val email: String
)

@Composable
fun Latihan1(profile: ProfileUser) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp)
        )
        {
            Text(text = "Nama: ${profile.name}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Usia: ${profile.age}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Email: ${profile.email}")

        }
    }



}

@Preview
@Composable
fun Previewlatihan1() {
    FirstJetpackTheme {
        Latihan1(
            ProfileUser("Budi", "20", "budi@example.com")
        )
    }
}

@Composable
fun Latihan2(produk: Produk) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = produk.name)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = produk.price)
    }
}

@Composable
fun ProdukScreen() {
    val produkList: List<Produk> = listOf(
        Produk("Laptop", "Rp 10.000.000"),
        Produk("Smartphone", "Rp 8.000.000")

    )
    LazyColumn {
        items(produkList) { produk ->
            Latihan2(produk)
        }
    }
}

@Preview
@Composable
fun Previewlatihan2() {
    FirstJetpackTheme {
        ProdukScreen()

    }
}

@Composable
fun Latihan3(profile: ProfileUser) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(8.dp),
        ) {
            Text(text = "Nama: ${profile.name}")
            Text(text = "Umur: ${profile.age}")
        }//end column
        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Email: ${profile.email}")
            Text(text = "Status: Aktif")
        }

    }
}

@Preview
@Composable
fun Previewlatihan3() {
    FirstJetpackTheme {
        Latihan3(profile = ProfileUser("Budi", "20", "budi@example.com"))
    }
}

@Composable
fun Latihan4(profile: ProfileUser) {

    Column(
        modifier = Modifier
            .padding(8.dp),
    ) {
        Text(text = "BIODATA", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nama: ${profile.name}")
        Text(text = "Umur: ${profile.age}")
        Text(text = "Email: ${profile.email}")
    }
}


@Preview
@Composable
fun Previewlatihan4() {
    FirstJetpackTheme {
        Latihan4(profile = ProfileUser("Ani", "25", "ani@example.com"))
    }
}
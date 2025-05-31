package com.example.firstjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpack.ui.theme.FirstJetpackTheme

class LatihanSelanjutnyaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tampilkan()
        }
    }
}

data class Barang(
    val imageResId: Int,
    val name: String
)

data class Stock(
    val name: String,
    val price: Int
)

@SuppressLint("DefaultLocale")
@Composable
fun Latihan5(stock: Stock) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Nama Barang:", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = stock.name)

            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Price:", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = String.format("Rp. %,d", stock.price))

            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Barang Beli: ${stock.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)


            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                   Icon(
                       imageVector = Icons.Default.ShoppingCart,
                       contentDescription = null,
                       modifier = Modifier.padding(end = 4.dp)
                   )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text("Beli")
            }//end Button

        } // end Column
    }
}

@Composable
fun StokLatihan5() {
    val stockList: List<Stock> = listOf(
        Stock("Laptop", 15000000),
        Stock("Kamera", 10000000),
        Stock("Headset", 5000000)
    )

    LazyColumn {
        items(stockList) { stock ->
            Latihan5(stock)
        }
    }


}

@Preview
@Composable
fun PreviewStockLatihan5() {
    FirstJetpackTheme {
        StokLatihan5()
    }
}

@Composable
fun Latihan6(produk: Barang) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(painterResource(id = produk.imageResId), contentDescription = null,
                modifier = Modifier.size(48.dp))//saran ditambahkan revisi
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = produk.name)

        }

    }
}

@Composable
fun Latihan6TampilanProduk() {
    val listProduk: List<Barang> = listOf(
        Barang(R.drawable.outline_photo_camera_24, "Kamera"),
        Barang(R.drawable.outline_tv_24, "TV"),
        Barang(R.drawable.outline_phone_android_24, "Handphone")
    )
    LazyColumn {
        items(listProduk) { produk ->
            Latihan6(produk)
        }

    }
}


@Preview
@Composable
fun PreviewLatihan6TampilanProduk() {
    FirstJetpackTheme {
        Latihan6TampilanProduk()
    }
}

@Composable
fun Latihan7() {
    val context = LocalContext.current
    var hasil by remember { mutableStateOf("") }
    var namaInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding( horizontal = 16.dp)//tambahan diberikan horizontal agar tidak mepet
    ) {

        Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)

        ) {
            Text(
                text = "Form Pendaftaran",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,//tambahan agar menonjol
                modifier = Modifier.padding(bottom = 2.dp)

            )

            OutlinedTextField(
                value = namaInput,
                onValueChange = { namaInput = it },
                label = { Text("Nama") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()

            )//end OutlinedTextField
            Spacer(modifier = Modifier.height(9.dp))
            OutlinedTextField(
                value = emailInput,
                onValueChange = { emailInput = it },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(9.dp))
            Button(

                onClick = {
                    if (namaInput.isNotEmpty() && emailInput.isNotEmpty()) {
                        hasil = "Nama: $namaInput, Email: $emailInput"
                        Toast.makeText(
                            context,
                            "Nama: $namaInput, Email: $emailInput",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Nama dan Email tidak boleh kosong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }//end if
                }
            ) {
                Text("Submit")
            } //end Button
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = hasil,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }//end Column


    }//end Row

}

@Preview
@Composable
fun PreviewLatihan7() {
    FirstJetpackTheme {
        Latihan7()
    }
}


@Composable
fun Latihan8() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )

    )
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Kartu Nama",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            ) // header

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painterResource(R.drawable.woman), contentDescription = null,
                modifier = Modifier
                    .size(64.dp) // di revisi ukuran dari 32 ke 64
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Column(modifier = Modifier.fillMaxWidth()) {

                Row {
                    Text(
                        text = "Nama: ",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Ani",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }//end Row

                Row {
                    Text(
                        text = "Email: ",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "email@email.com",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.padding(5.dp))

            }//end Column

        } //end Row
    }//end Column
}// end Card


@Preview
@Composable
fun PreviewLatihan8() {
    FirstJetpackTheme {
        Latihan8()
    }
}

@Composable
fun Tampilkan() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
        // .verticalScroll(rememberScrollState())//Tambahkan
        // verticalScroll(rememberScrollState()) karena beberapa
        // komponen akan overflow di layar kecil.

    ) {
        Column {
            StokLatihan5()
            Latihan6TampilanProduk()
            Latihan7()
            Latihan8()
        }

    }

}

@Preview
@Composable
fun PreviewTampilkan() {
    FirstJetpackTheme {
        Tampilkan()
    }
}


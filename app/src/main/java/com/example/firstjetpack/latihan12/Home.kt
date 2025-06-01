package com.example.firstjetpack.latihan12


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstjetpack.R
import com.example.firstjetpack.latihan12.ui.theme.FirstJetpackTheme

data class MasterBarang(
    val img: Int,
    val name: String,
    val price:String,
    val desc: String
)

@Composable
fun MasterBarang(navController: NavHostController) {
    val listBarang: List<MasterBarang> = listOf(
        MasterBarang(R.drawable.outline_tv_24, "TV", "Rp. 10.000.000","Barang cantik"),
        MasterBarang(R.drawable.outline_photo_camera_24, "Camera", "Rp. 5.000.000","Barang antik"),
        MasterBarang(R.drawable.outline_phone_android_24, "Headphone", "Rp. 3.000.000","Barang mahal"),
    )

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        // Header hanya satu kali di atas
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Gambar",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Nama Barang",
                    modifier = Modifier.weight(2f),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        // Data barang
        items(listBarang) { barang ->
            Home(barang,navController)
        }
    }
}

@Composable
fun Home(masterBarang: MasterBarang,navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = masterBarang.img),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(40.dp)
                    .clickable(
                        onClick = {
                            navController.navigate("detail/${masterBarang.img}/${masterBarang.name}/${masterBarang.price}/${masterBarang.desc}")
                        }
                    ),

            )
            Text(
                text = masterBarang.name,
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 8.dp),
                style = MaterialTheme.typography.bodyMedium,

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMasterBarang(){
    val navController = rememberNavController()
    FirstJetpackTheme {
        MasterBarang(navController)
    }

}
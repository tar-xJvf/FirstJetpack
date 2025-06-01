package com.example.firstjetpack.latihan12

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpack.R
import com.example.firstjetpack.navigation.ui.theme.FirstJetpackTheme

@Composable
fun DetailProduct(img: Int, name: String, price: String, desc: String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(14.dp)
    ) {
        Column( // 🔧 Bungkus semua isi Card dalam Column
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Detail Produk",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(15.dp)) // pakai height, bukan padding

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp)
                        .border(2.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                        .clip(CircleShape)
                        .background(Color.DarkGray, CircleShape),
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = name,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = price,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = desc,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(onClick = {
                        Toast.makeText(context, "Produk dibeli: $name", Toast.LENGTH_SHORT).show()
                    }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddShoppingCart,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        }
                        Text(text = "Beli")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDetailProduct() {
    FirstJetpackTheme {
        DetailProduct(R.drawable.outline_tv_24, "TV", "Rp. 10.000.000", "Barang cantik")
    }
}
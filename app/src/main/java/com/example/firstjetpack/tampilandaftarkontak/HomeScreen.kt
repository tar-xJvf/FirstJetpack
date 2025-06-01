package com.example.firstjetpack.tampilandaftarkontak

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstjetpack.R
import com.example.firstjetpack.navigation.ui.theme.FirstJetpackTheme


// data class contact
data class OurContact(
    val image: Int,
    val name: String,
    val number: String
)

@Composable
fun HomeScreen(contact: OurContact,navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(14.dp)
    ) {
        Text(
            text = "Daftar Kontak", modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
        ) {
            Image(
                painterResource(contact.image),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp)
                    .border(2.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                    .clip(CircleShape)
                    .background(Color.DarkGray, CircleShape),
                )//end Image

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = contact.name,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Button(
                    onClick = {
                    navController.navigate("detail/${contact.image}/${Uri.encode(contact.name)}/${Uri.encode(contact.number)}")
                    }, //end onClick
                         modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call, contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Detail")
                }
            }
        } //end Row


    }//end Card
}


@Composable
fun ContactList(navController: NavHostController) {
    val contactList: List<OurContact> = listOf(
        OurContact(R.drawable.before, "Jimmy", "08122222"),
        OurContact(R.drawable.woman, "Ani", "0817382"),
        OurContact(R.drawable.before, "Hakim", "08157384"),
    )

    LazyColumn {
        items(contactList) { contact ->
            HomeScreen(contact,navController)
        }
    }


}

@Preview
@Composable
fun PreviewContactList() {
    FirstJetpackTheme {
        val navController = rememberNavController()
        ContactList(navController)
    }
}


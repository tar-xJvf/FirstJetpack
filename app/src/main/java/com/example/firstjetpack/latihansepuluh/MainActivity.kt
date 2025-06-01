package com.example.firstjetpack.latihansepuluh

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpack.latihansepuluh.ui.theme.FirstJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Latihan10()
        }
    }
}

@Composable
fun Latihan10() {

    val context = LocalContext.current
    var inputName by remember { mutableStateOf("") }
    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }
    var passwordVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(4.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Icon and text  sejajar
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Form Registrasi",
                    modifier = Modifier
                        .padding(4.dp),
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
            }//end Row
            Spacer(modifier = Modifier.padding(4.dp))
            // form registration

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically // most important
                ) {
                    Text(
                        text = "Nama",
                        modifier = Modifier
                            .padding(2.dp)
                            .width(80.dp),
                        fontSize = 14.sp

                    )
                    OutlinedTextField(
                        value = inputName,
                        onValueChange = { inputName = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nama") },


                        )
                }//end Row
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically // most important
                ) {
                    Text(
                        text = "Email",
                        modifier = Modifier
                            .padding(2.dp)
                            .width(80.dp),
                        fontSize = 14.sp

                    )
                    OutlinedTextField(
                        value = inputEmail,
                        onValueChange = {
                            inputEmail = it
                            isEmailValid = Patterns.EMAIL_ADDRESS.matcher(it).matches()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = androidx.compose.ui.text.input.KeyboardType.Email
                        )

                    )
                }//end Row
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically // most important
                ) {
                    Text(
                        text = "Password",
                        modifier = Modifier
                            .padding(2.dp)
                            .width(80.dp),
                        fontSize = 14.sp

                    )
                    OutlinedTextField(
                        value = inputPassword,
                        onValueChange = { inputPassword = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Password") },
                        textStyle = TextStyle(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = androidx.compose.ui.text.input.KeyboardType.Password
                        ),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff

                            // Deskripsi konten untuk aksesibilitas
                            val description = if (passwordVisible) "Hide password" else "Show password"

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, description)
                            }
                        }

                    )
                }//end Row
                Spacer(modifier = Modifier.padding(10.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // most important
            ) {
                Button(
                    onClick = {
                        if (inputPassword.length < 6) {
                            Toast.makeText(
                                context,
                                "Password minimal 6 karakter",
                                Toast.LENGTH_SHORT
                            ).show()
                        }else if (!isEmailValid) {
                            Toast.makeText(context, "Email tidak valid", Toast.LENGTH_SHORT).show()
                        }
                        else if (inputName.isNotEmpty() && inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                            Toast.makeText(context, "Sukses", Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, SuccessActivity::class.java).apply {
                                putExtra("inputName", inputName)
                                putExtra("inputEmail", inputEmail)

                            }
                            context.startActivity(intent)

                        } else {
                            Toast.makeText(context, "Form tidak boleh kosong", Toast.LENGTH_SHORT)
                                .show()
                        }

                    }
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                    }
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Submit")
                }
                Button(onClick = {}) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                    }
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Clear")
                }
            } // end Row


        }//end Column
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLatihan10() {
    FirstJetpackTheme {
        Latihan10()
    }
}
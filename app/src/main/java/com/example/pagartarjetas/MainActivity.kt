package com.example.pagartarjetas

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pagartarjetas.ui.theme.PagarTarjetasTheme
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagarTarjetasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var noTarjeta by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    var mesExpiracion by remember { mutableStateOf("") }
    var añoExpiracion by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "Pagar Con Tarjeta",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(text = "Número de Tarjeta:")
        OutlinedTextField(
            value = noTarjeta,
            onValueChange = { noTarjeta = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("XXXX XXXX XXXX XXXX") }
        )

        Text(text = "Fecha de Expiración:")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Mes
            OutlinedTextField(
                value = mesExpiracion,
                onValueChange = { mesExpiracion = it
                    //  2   numberosss entre 1-12
                    /*if (it.length <= 2 && it.all { char -> char.isDigit() }) {
                        val number = it.toIntOrNull() ?: 0
                        if (number in 0..12) {
                            mesExpiracion = it
                        }
                    }*/
                },
                modifier = Modifier.weight(1f),
                placeholder = { Text("MM") },
                label = { Text("Mes") }
            )

            // Año
            OutlinedTextField(
                value = añoExpiracion,
                onValueChange = { añoExpiracion= it
                    //  2 digits for año
                    /*if (it.length <= 2 && it.all { char -> char.isDigit() }) {
                        yearExpiracion = it
                    }*/
                },
                modifier = Modifier.weight(1f),
                placeholder = { Text("YY") },
                label = { Text("Año") }
            )
        }

        Text(text = "CVV:")
        OutlinedTextField(
            value = cvv,
            onValueChange = { cvv = it
                // Limite CVV to 3 o 4 digitos
                /*if (it.length <= 4 && it.all { char -> char.isDigit() }) {
                    cvv = it
                }*/
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("XXX") },
            visualTransformation = PasswordVisualTransformation(),
            maxLines = 1
        )

        Button(onClick = {/*TODO*/ } ) {
            Text(text = "PAGAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PagarTarjetasTheme {
        Greeting("Android")
    }
}
package com.vicente.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarjeta()
        }
    }
}

@Composable
fun Tarjeta() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagenHeroe()
        Personaje()
    }
}

@Composable
fun Personaje() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column {
            Text("Gohan")
            Text("Son Goku")
        }
    }
}

@Composable
fun ImagenHeroe() {
    Image(
        painter = painterResource(R.drawable.goku_normal),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(bottom = 8.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarjeta()
}
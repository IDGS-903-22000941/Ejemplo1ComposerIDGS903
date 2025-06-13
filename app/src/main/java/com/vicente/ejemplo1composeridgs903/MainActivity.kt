package com.vicente.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("freezer", " Freezer es el tirano espacial y el principal antagonista de la saga de Freezer"),
    PersonajeTarjeta("krillin", " Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball."),
    PersonajeTarjeta("chi", "Esposa de Goku y madre de Gohan. Es la princesa del Monte Fry-pan siendo la hija de la fallecida reina de esta montaña y el Rey Gyuma, ella terminaría conociendo a Son Goku "),
    PersonajeTarjeta("mrsatan", " Luchador humano famoso por llevarse el mérito de las victorias de los Guerreros "),
    PersonajeTarjeta("android17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal "),
    PersonajeTarjeta("majinbuu", "También conocido como Boo original, es la forma original y pura de Majin-Boo, y la última forma de Boo que aparece en Dragon Ball Z. "),
    PersonajeTarjeta("jiren", " Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo"),
    PersonajeTarjeta("vermoudh", " Es el individuo que actualmente ostenta el cargo de Dios de la Destrucción en el Universo 11,"),
    PersonajeTarjeta("bulma", " Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT")
)

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn {
        items(personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta) {
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row (
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe(personaje.title)
            Personajes(personaje)
        }
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text = name, color = color, style = style, maxLines = lines)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta) {
    var expanded by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier.padding(start = 16.dp).clickable {
            expanded = !expanded
        }
    ){
        Personaje(
            personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium
        )

        Personaje(
            personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun ImagenHeroe(imageName: String ) {
    val context = LocalContext.current
    val ImageResId = remember(imageName) {
        context.resources.getIdentifier(imageName.lowercase()
            , "drawable", context.packageName)
    }
    Image(
        painter = painterResource(id = ImageResId),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarjeta(tarjetas)
}
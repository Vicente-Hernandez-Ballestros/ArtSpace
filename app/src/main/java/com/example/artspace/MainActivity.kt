package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    
    // Se declaran las variables de las imagenes para agilizar un poco el llamado en los recursos
    val firstArtwork = R.drawable.imagen_logo_wbc
    val secondArtwork = R.drawable.imagen_grupoa_wbc
    val thirdArtwork = R.drawable.imagen_grupob_wbc
    val fourthArtwork = R.drawable.imagen_grupoc_wbc
    val fifthArtwork = R.drawable.imagen_grupod_wbc
    val sixthArtwork = R.drawable.imagen_cronograma_wbc
    
    
    // le damos un titulo
    var title by remember {
        mutableStateOf(R.string.wbc)
    }
    // y un subtitulo
    var subttle by remember {
        mutableStateOf(R.string.wbc_description)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = modifier.size(16.dp))
        ArtworkTitle(title = title, subttle = subttle)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)

        ) {
            //  creamos el boton anterior
            Button(
                // creamos el evento onclick del boton previo
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = sixthArtwork
                            title = R.string.Schedule
                            subttle = R.string.Schedule_description
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.wbc
                            subttle = R.string.wbc_description
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.grup_a
                            subttle = R.string.grup_a_description
                        }
                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.grup_b
                            subttle = R.string.grup_b_description
                        }
                        fifthArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.grup_c
                            subttle = R.string.grup_c_description
                        }
                        else -> {
                            currentArtwork = sixthArtwork
                            title = R.string.grup_d
                            subttle = R.string.grup_d_description
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_700)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }


            //  boton sigiente
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.grup_a
                            subttle = R.string.grup_a_description
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.grup_b
                            subttle = R.string.grup_b_description
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.grup_c
                            subttle = R.string.grup_c_description
                        }
                        fourthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.grup_d
                            subttle = R.string.grup_d_description
                        }
                        fifthArtwork -> {
                            currentArtwork = sixthArtwork
                            title = R.string.Schedule
                            subttle = R.string.Schedule_description
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.wbc
                            subttle = R.string.wbc_description
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_700)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.wbc),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes subttle: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Artwork nombre
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_700),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline

        )

        // Artwork trofeos
        Text(
            text = stringResource(id = subttle),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            textAlign = TextAlign.Center

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}
package com.example.applimonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applimonada.ui.theme.AppLimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background) {

                  Redondolimao ()

                }
            }
        }
    }
}
@Preview
@Composable
fun Redondolimao() {
   var espremer by remember { mutableStateOf(1) }

   var tela by remember { mutableStateOf(1) }

    when (tela) {
        1 ->  Conteudolimao(
            R.string.limoeiro,
            R.drawable.limoeiro,
            onImageClick = {
                tela = 2
                espremer = (2..4).random()
            }
        )
        2 ->  Conteudolimao(
            R.string.limao,
            R.drawable.limonada,
            onImageClick = {
                if (espremer>1)
                    espremer--
                else
                tela = 3

            }
        )
        3 ->  Conteudolimao(
            R.string.copo_de_limonada,
            R.drawable.copo_limonada,
                onImageClick = {
                    tela = 4
            }
        )
        4 ->  Conteudolimao(
            R.string.copo_vazio,
            R.drawable.reiniciar,
                    onImageClick = {
                        tela = 1
            }
        )
    }
}
@Composable
fun Conteudolimao(recursoTextoId: Int,
                  recursoImageId: Int,
                  onImageClick:()->Unit)
{

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(recursoTextoId),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )

        Image(
            painter = painterResource(id = recursoImageId),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .border(
                    BorderStroke(2.dp, Color.Cyan),
                    RoundedCornerShape(15.dp)
                )
                .clickable(onClick = onImageClick)
        )

    }
    }






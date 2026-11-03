package edu.temple.countdowntimer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import edu.temple.countdowntimer.ui.theme.CountdowntimerTheme

const val TIMER_KEY = "timerkey"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountdowntimerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Timer(
                        modifier = Modifier.padding(innerPadding)
                    )



                }
            }
        }
    }
}

@Composable
fun Timer(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize(), Arrangement.Center,
        Alignment.CenterHorizontally) {
        Text(
            text = "Hello !",
            modifier = modifier

        )

        var timerValue by rememberSaveable { mutableStateOf("") }

        val context = LocalContext.current


        TextField(
            value = timerValue,

            onValueChange = { timerValue = it }

        )

        Button(
            {
                context.startService(
                    Intent(context, MyTimerService::class.java).apply {
                        putExtra(TIMER_KEY, timerValue.toInt())
                    }
                )
            }
        ) {Text("Start")}

    }

}

@Preview(showBackground = true)
@Composable
fun TimerPreview() {
    CountdowntimerTheme {
        Timer()


    }
}
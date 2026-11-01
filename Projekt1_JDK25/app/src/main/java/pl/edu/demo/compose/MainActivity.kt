package pl.edu.demo.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Jedyna aktywność aplikacji.
 *
 * Activity zarządza cyklem życia ekranu, a @Composable tworzy jego interfejs.
 * Logi cyklu życia można oglądać w Android Studio -> Logcat (filtr: LifecycleDemo).
 */
class MainActivity : ComponentActivity() {

    // mutableStateOf informuje Compose, że zmiana wartości może wymagać odświeżenia UI.
    private var ostatnieZdarzenie by mutableStateOf("oczekiwanie na onCreate")

    private fun zalogujCykl(zdarzenie: String) {
        ostatnieZdarzenie = zdarzenie
        Log.d("LifecycleDemo", "MainActivity.$zdarzenie")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        zalogujCykl("onCreate")

        // setContent uruchamia interfejs Jetpack Compose (zamiast setContentView z XML).
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    EkranDemonstracyjny(
                        zdarzenieCyklu = ostatnieZdarzenie,
                        onZamknij = { finish() } // Zamyka Activity; obserwuj Logcat.
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        zalogujCykl("onStart")
    }

    override fun onResume() {
        super.onResume()
        zalogujCykl("onResume")
    }

    override fun onPause() {
        super.onPause()
        zalogujCykl("onPause")
    }

    override fun onStop() {
        super.onStop()
        zalogujCykl("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        zalogujCykl("onRestart")
    }

    override fun onDestroy() {
        zalogujCykl("onDestroy")
        super.onDestroy()
    }
}

/**
 * @Composable oznacza funkcję opisującą fragment interfejsu.
 *
 * W Jetpack Compose rolę klasycznego "Label" pełni komponent Text.
 * Column układa elementy pionowo, a Row poziomo.
 */
@Composable
fun EkranDemonstracyjny(
    zdarzenieCyklu: String,
    onZamknij: () -> Unit
) {
    // rememberSaveable przechowuje stan interfejsu także np. po obrocie ekranu.
    var tekstEtykiety by rememberSaveable { mutableStateOf("Witaj w Jetpack Compose!") }
    var licznik by rememberSaveable { mutableStateOf(0) }
    var zielonyTekst by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "Kotlin + Jetpack Compose",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Jedna aktywność, Text (Label), Button, Row, Column i cykl życia.",
            style = MaterialTheme.typography.bodyMedium
        )

        // TEXT = ETYKIETA (LABEL). Po zmianie stanu Compose przerysuje tylko to, co trzeba.
        Text(
            text = tekstEtykiety,
            color = if (zielonyTekst) Color(0xFF2E7D32)
                    else MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = "Liczba kliknięć: $licznik")

        // ROW: dwa przyciski znajdują się obok siebie.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    // Akcja 1: zmiana treści etykiety.
                    tekstEtykiety = "Cześć, studencie!"
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Powitaj")
            }

            Button(
                onClick = {
                    // Akcja 2: zmieniamy dwa stany jednocześnie.
                    licznik++
                    tekstEtykiety = "Kliknięto $licznik razy!"
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Kliknij +1")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    // Akcja 3: zmiana koloru oraz tekstu etykiety.
                    zielonyTekst = !zielonyTekst
                    tekstEtykiety = if (zielonyTekst) "Tekst jest zielony"
                                    else "Tekst ma zwykły kolor"
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Zmień kolor")
            }

            OutlinedButton(
                onClick = {
                    // Akcja 4: przywracamy stan początkowy ekranu.
                    tekstEtykiety = "Witaj w Jetpack Compose!"
                    licznik = 0
                    zielonyTekst = false
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Resetuj")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Ostatnie zdarzenie Activity: $zdarzenieCyklu")
        Text(
            text = "Otwórz Logcat i wpisz LifecycleDemo, aby zobaczyć wszystkie metody.",
            style = MaterialTheme.typography.bodySmall
        )

        OutlinedButton(
            onClick = onZamknij, // Akcja 5: finish() zamknie jedyną Activity.
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zamknij aktywność")
        }
    }
}

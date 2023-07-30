package dev.vladleesi.githubitty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.vladleesi.githubitty.domain.repository.SearchRepository
import dev.vladleesi.githubitty.presentation.screen.GithubittyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = SearchRepository()
        setContent {
            GithubittyApp(repo)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        GreetingView("Hello, Android!")
    }
}

package dev.vladleesi.githubitty.presentation

import androidx.compose.ui.window.ComposeUIViewController
import dev.vladleesi.githubitty.presentation.screen.GithubittyApp

fun MainViewController() =
    ComposeUIViewController {
        GithubittyApp()
    }
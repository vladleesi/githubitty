package dev.vladleesi.githubitty.presentation

import androidx.compose.ui.window.ComposeUIViewController
import dev.vladleesi.githubitty.domain.repository.SearchRepository
import dev.vladleesi.githubitty.presentation.screen.GithubittyApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val repo = SearchRepository()
    return ComposeUIViewController {
        GithubittyApp(repo)
    }
}
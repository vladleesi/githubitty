package dev.vladleesi.githubitty.presentation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.ComposeUIViewController
import dev.vladleesi.githubitty.domain.repository.SearchRepository
import dev.vladleesi.githubitty.domain.state.IssueListState
import dev.vladleesi.githubitty.presentation.screen.GithubittyApp

fun MainViewController() =
    ComposeUIViewController {
        val repo = SearchRepository()
        LaunchedEffect(Unit) {
            repo.getAllIssue()
        }

        var innerState by remember { mutableStateOf(IssueListState(isLoading = true)) }
        repo.onChange { state ->
            // TODO: Move this checking to repo
            state.response?.let {
                innerState = state
            }
        }

        GithubittyApp(innerState)
    }
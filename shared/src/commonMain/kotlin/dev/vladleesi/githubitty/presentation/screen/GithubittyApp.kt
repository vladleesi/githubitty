package dev.vladleesi.githubitty.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vladleesi.githubitty.domain.repository.SearchRepository
import dev.vladleesi.githubitty.domain.state.IssueListState
import dev.vladleesi.githubitty.presentation.component.IssueList
import dev.vladleesi.githubitty.presentation.component.LoadingIndicator

@Composable
fun GithubittyApp(repo: SearchRepository, modifier: Modifier = Modifier) {
    GithubittyTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val state = repo.stateFlow.collectAsState()
            LaunchedEffect(Unit) {
                repo.loadAllIssues()
            }
            MainScreen(state.value)
        }
    }
}

@Composable
private fun MainScreen(state: IssueListState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 72.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Issues", fontSize = 42.sp, fontWeight = FontWeight.SemiBold)
        if (state.isLoading) {
            LoadingIndicator()
        } else {
            IssueList(state.response?.items.orEmpty())
        }
    }
}

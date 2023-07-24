package dev.vladleesi.githubitty.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.vladleesi.githubitty.data.model.Issue


@Composable
fun IssueList(list: List<Issue>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        // TODO: Doesn't work
        verticalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = true
    ) {
        items(list) { issue ->
            IssueCard(issue)
        }
    }
}
package dev.vladleesi.githubitty.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.vladleesi.githubitty.data.model.Issue

@Composable
fun IssueCard(issue: Issue) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${issue.state}",
                style = typography.subtitle1
            )
            Text(
                text = "${issue.title}",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${issue.number}",
                style = typography.body1
            )
            Text(
                text = "${issue.repository_url}",
                style = typography.body1
            )
            Text(
                text = "${issue.milestone?.number}",
                style = typography.body2
            )
            Text(
                text = "Labels: ${issue.labels}",
                style = typography.body2
            )
            Text(
                text = "Open Date: ${issue.updated_at}",
                style = typography.body2
            )
        }
    }
}
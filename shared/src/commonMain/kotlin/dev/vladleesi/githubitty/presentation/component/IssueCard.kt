package dev.vladleesi.githubitty.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.unit.sp
import dev.vladleesi.githubitty.data.model.Issue

@OptIn(ExperimentalLayoutApi::class)
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
                text = "${issue.title}",
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            FlowRow(modifier = Modifier.fillMaxWidth()) {
                Text("#${issue.number} ")
                Text("${issue.state} ")
                Text("by ${issue.user?.login} ")
                Text("in ${issue.repository_url} ")
            }
            Text(
                text = "Labels: ${issue.labels?.joinToString { it.name.toString() }}",
                style = typography.body2
            )
            Text(
                text = "Open Date: ${issue.updated_at}",
                style = typography.body2
            )
        }
    }
}
package dev.vladleesi.githubitty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchIssueResponse(
    val incomplete_results: Boolean?,
    val items: List<Issue>?,
    val total_count: Int?
)
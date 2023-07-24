package dev.vladleesi.githubitty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Milestone(
    val closed_at: String?,
    val closed_issues: Int?,
    val created_at: String?,
    val creator: User?,
    val description: String?,
    val due_on: String?,
    val html_url: String?,
    val id: Long?,
    val labels_url: String?,
    val node_id: String?,
    val number: Int?,
    val open_issues: Int?,
    val state: String?,
    val title: String?,
    val updated_at: String?,
    val url: String?
)
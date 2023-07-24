package dev.vladleesi.githubitty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val active_lock_reason: String?,
    val assignee: User?,
    val assignees: List<User>?,
    val author_association: String?,
    val body: String?,
    val closed_at: String?,
    val comments: Int?,
    val comments_url: String?,
    val created_at: String?,
    val events_url: String?,
    val html_url: String?,
    val id: Long?,
    val labels: List<Label>?,
    val labels_url: String?,
    val locked: Boolean?,
    val milestone: Milestone?,
    val node_id: String?,
    val number: Int?,
    val reactions: Reactions?,
    val repository_url: String?,
    val score: Double?,
    val state: String?,
    val state_reason: String?,
    val timeline_url: String?,
    val title: String?,
    val updated_at: String?,
    val url: String?,
    val user: User?
)
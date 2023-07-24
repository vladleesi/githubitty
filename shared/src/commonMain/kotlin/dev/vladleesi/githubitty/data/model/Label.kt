package dev.vladleesi.githubitty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Label(
    val color: String?,
    val id: Long?,
    val name: String?,
    val node_id: String?,
    val url: String?
)
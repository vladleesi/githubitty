package dev.vladleesi.githubitty.domain.state

import dev.vladleesi.githubitty.data.model.SearchIssueResponse

data class IssueListState(
    val isLoading: Boolean,
    val response: SearchIssueResponse? = null
)

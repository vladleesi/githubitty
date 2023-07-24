package dev.vladleesi.githubitty.domain.repository

import dev.vladleesi.githubitty.data.api.remote.search
import dev.vladleesi.githubitty.data.model.SearchIssueResponse
import dev.vladleesi.githubitty.domain.state.IssueListState
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.utils.io.core.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

// TODO: Move to DI
class SearchRepository {

    // TODO: Move to base class
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val _stateFlow = MutableStateFlow(IssueListState(isLoading = true))
    val stateFlow: StateFlow<IssueListState>
        get() = _stateFlow

    // TODO: Naming
    suspend fun getAllIssue() = coroutineScope.launch {

        val searchIssueResponse = search(pageSize = 20, page = 1).body<SearchIssueResponse>()
        Napier.d(
            tag = this::class.simpleName,
            message = "Total issues: ${searchIssueResponse.total_count}"
        )
        _stateFlow.emit(IssueListState(isLoading = false, response = searchIssueResponse))
    }

    // TODO: Implement automatic unsubscribe
    fun onChange(provideNewState: ((IssueListState) -> Unit)): Closeable {
        val job = Job()

        stateFlow
            .onEach(provideNewState::invoke)
            .launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }

    // TODO: Move to base class
    fun cancelCoroutines() {
        coroutineScope.coroutineContext.cancelChildren()
    }
}
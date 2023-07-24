package dev.vladleesi.githubitty.data.api.remote

import dev.vladleesi.githubitty.data.api.httpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLBuilder


suspend fun search(pageSize: Int, page: Int): HttpResponse =
    search {
        encodedParameters.append("q", "is:issue+is:open")
        encodedParameters.append("per_page", pageSize.toString())
        encodedParameters.append("page", page.toString())
    }

/**
 * Executes a [block] that configures the [URLBuilder] with search filters.
 * */
private suspend fun search(block: URLBuilder.(URLBuilder) -> Unit): HttpResponse =
    httpClient.get("search/issues") {
        url(block::invoke)
    }
package dev.vladleesi.githubitty

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
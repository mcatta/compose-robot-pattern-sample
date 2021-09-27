package dev.marcocattaneo.robotpatternsample.presentation

sealed class Route(val path: String) {

    open fun getNavigableRoute() = path

    object Welcome: Route("welcome")

    class RepoList(private val username: String): Route("repos/{username}") {
        override fun getNavigableRoute(): String {
            return "repos/$username"
        }
    }

    class RepoDetail(private val id: Long): Route("repos/detail/{id}") {
        override fun getNavigableRoute(): String {
            return "repos/detail/$id"
        }
    }

}
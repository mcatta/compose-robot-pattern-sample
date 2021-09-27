package dev.marcocattaneo.robotpatternsample.domain.domain

data class GithubRepo(
    val id: Long,
    val name: String,
    val full_name: String,
    val private: Boolean,
    val description: String,
    val url: String,
    val owner: Owner
) {

    data class Owner(
        val login: String,
        val id: Long
    )

}
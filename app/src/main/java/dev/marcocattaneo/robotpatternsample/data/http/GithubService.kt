package dev.marcocattaneo.robotpatternsample.data.http

import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{username}/repos")
    suspend fun repositories(@Path("username") username: String): List<GithubRepo>

}
package com.example.peliculas.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET("/?apikey=fb7aca4")
    suspend fun findMoviesByName(@Query("s") query: String) : MovieResponse

    @GET("/?apikey=fb7aca4")
    suspend fun getMovieById(@Query("i") id: String) : Movie
}
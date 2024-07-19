package com.example.peliculas.data

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("Search") val results: List<Movie>,
    @SerializedName("Response") val response: String
)

data class Movie (
    @SerializedName("imdbID") val id: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val image: String,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Country") val country: String?
)
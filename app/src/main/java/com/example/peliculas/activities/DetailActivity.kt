package com.example.peliculas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peliculas.R
import com.example.peliculas.data.Movie
import com.example.peliculas.data.MoviesApiService
import com.example.peliculas.databinding.ActivityDetailBinding
import com.example.peliculas.utils.RetrofitProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE_ID = "MOVIE_ID"
    }

    private lateinit var binding: ActivityDetailBinding

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(EXTRA_MOVIE_ID)!!

        getMovie(id)
    }

    private fun loadData() {
        binding.titleTextView.text = movie.title
        binding.yearTextView.text = movie.year
        binding.countryTextView.text = movie.country
        binding.directorTextView.text = movie.director
        binding.genreTextView.text = movie.genre
        binding.runtimeTextView.text = movie.runtime
        binding.plotTextView.text = movie.plot
        Picasso.get().load(movie.image).into(binding.posterImageView)
    }

    private fun getMovie(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = RetrofitProvider.getRetrofit().create(MoviesApiService::class.java)
                val result = apiService.getMovieById(id)
                movie = result

                runOnUiThread {
                    loadData()
                }
                //Log.i("HTTP", "${result.results}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
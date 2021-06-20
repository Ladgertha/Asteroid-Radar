package ru.ladgertha.asteroidradar.api.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ladgertha.asteroidradar.BuildConfig

class AsteroidApiService {

    val retrofitService: NasaApiService by lazy { retrofit.create(NasaApiService::class.java) }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BuildConfig.NASA_BASE_URL)
        .build()

    interface NasaApiService {
        //https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=YOUR_API_KEY
        @GET("neo/rest/v1/feed")
        fun getAsteroidList(
            @Query("api_key") apiKey: String
        ): Call<String>
    }
}
package ru.ladgertha.asteroidradar.api.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ladgertha.asteroidradar.BuildConfig
import ru.ladgertha.asteroidradar.api.ImageOfTheDay

class ImageOfTheDayService {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofitService: NasaApiService by lazy { retrofit.create(NasaApiService::class.java) }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BuildConfig.NASA_BASE_URL)
        .build()

    interface NasaApiService {

        //https://api.nasa.gov/planetary/apod?api_key=YOUR_API_KEY
        @GET("planetary/apod")
        fun getImageOfTheDay(
            @Query("api_key") apiKey: String
        ): Call<ImageOfTheDay>
    }
}
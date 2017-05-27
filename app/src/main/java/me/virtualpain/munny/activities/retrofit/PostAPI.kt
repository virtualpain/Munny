package me.virtualpain.munny.activities.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PostAPI {
    @GET("postsa/{id}")
    fun viewPost(@Path("id") id: Int): Call<PostModel>
}

fun postApi(): PostAPI
{
    val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    return retrofit.create(PostAPI::class.java)
}
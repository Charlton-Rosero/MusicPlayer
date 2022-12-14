package com.alecbrando.musicplayer.data.remote

import com.alecbrando.musicplayer.util.Constants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface FileApi {
    @GET("{url}")

    suspend fun downloadSong(@Path("url") url: String): Response<ResponseBody>

    companion object{
        val instance by lazy{
            Retrofit.Builder()
                .baseUrl("https://music-api-summer-2022.s3.amazonaws.com/")
                .build()
                .create(FileApi::class.java)
        }
    }
}
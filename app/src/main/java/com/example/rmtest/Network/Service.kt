package com.example.rmtest.Network

import com.example.rmtest.Model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("character")
    suspend fun getCharactersPage(@Query("page") pageIndex: Int): Response<CharacterResponse>
    @GET("character/{id}")
    suspend fun getcharactersById(@Path("id") id:Int): Response<CharacterResponse>
}
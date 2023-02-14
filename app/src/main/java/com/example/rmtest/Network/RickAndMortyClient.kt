package com.example.rmtest.Network

import com.example.rmtest.Model.CharacterResponse
import com.example.rmtest.Model.SimpleResponse
import retrofit2.Response

class RickAndMortyClient(private val service: Service) {
    suspend fun getCharacterById(id: Int): SimpleResponse<CharacterResponse> {
        return safeApiCall { service.getcharactersById(id) }
    }
    suspend fun getCharactersPage(pageIndex: Int) : SimpleResponse<CharacterResponse>{
        return safeApiCall { service.getCharactersPage(pageIndex) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T>{
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e:java.lang.Exception){
            SimpleResponse.failure(e)
        }
    }
}
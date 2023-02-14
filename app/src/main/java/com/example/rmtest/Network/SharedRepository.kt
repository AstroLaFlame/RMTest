package com.example.rmtest.Network

import com.example.rmtest.Model.CharacterResponse

class SharedRepository {
    suspend fun getCharacterById(id: Int): CharacterResponse?{
        val request = Network.rickAndMortyClient.getCharactersPage(id)

        if (request.failed){
            return null
        }

        if (!request.isSuccessful){
            return null
        }
        return request.body
    }

    suspend fun getCharacterPage(id: Int): CharacterResponse?{
        val request = Network.rickAndMortyClient.getCharactersPage(id)

        if (request.failed){
            return null
        }

        if (!request.isSuccessful){
            return null
        }
        return request.body
    }
}
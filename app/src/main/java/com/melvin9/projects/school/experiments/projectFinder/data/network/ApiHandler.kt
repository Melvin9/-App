package com.melvin9.projects.school.experiments.projectFinder.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.melvin9.projects.school.experiments.projectFinder.data.network.response.ResponseProject
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiHandler {
    @GET("projects")
    fun getProjectsAsync(): Deferred<ResponseProject>

    companion object {
        operator fun invoke(): ApiHandler {
            return Retrofit.Builder()
                .baseUrl("https://salty-plateau-61343.herokuapp.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiHandler::class.java)
        }
    }
}
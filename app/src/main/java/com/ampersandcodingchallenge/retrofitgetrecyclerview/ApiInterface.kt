package com.ampersandcodingchallenge.retrofitgetrecyclerview

import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/objects")
    suspend fun getAllUsers():Response<Products>
}
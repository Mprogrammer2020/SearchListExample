package com.netset.mvpexample.network


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ApiInterface {

    @GET("ApiUrl")
    fun apiName (@Query("api_token") api_token: String): Observable<Response<Void>>

}
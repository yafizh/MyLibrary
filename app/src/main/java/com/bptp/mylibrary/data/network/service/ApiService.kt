package com.bptp.mylibrary.data.network.service

import com.bptp.mylibrary.data.network.model.response.Book
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import java.util.concurrent.TimeUnit

interface ApiService {
    @GET("index.php?request=getAllBooks")
    suspend fun getBookData(): List<Book>

//    @POST("auth/register")
//    suspend fun postRegisterUser(@Body registerRequest: AuthRequest): BaseAuthResponse<RegisterData, String>
//
//    @GET("auth/me")
//    suspend fun getSyncUser(): BaseAuthResponse<UserData, String>
//
//    @GET("users")
//    suspend fun getUserData(): BaseAuthResponse<UserData, String>
//
//    @PUT("users")
//    suspend fun putUserData(@Body data: RequestBody): BaseAuthResponse<UserData, String>


    companion object {
        @JvmStatic
        operator fun invoke() : ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://magangbptp.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
package com.example.ej5m6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

        companion object {
            private const val URL_BASE =
                "https://android-kotlin-fun-mars-server.appspot.com/"

            fun getRetrofitClient() : RetrofitClient {
                val mRetrofit = Retrofit.Builder()
                    .baseUrl(URL_BASE)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return mRetrofit.create(RetrofitClient::class.java)
            }
        }
    }

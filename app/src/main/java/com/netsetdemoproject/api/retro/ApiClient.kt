package com.netset.mvpexample.network


import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.netsetdemoproject.utils.NetSetConstants
//import com.netset.mvpexample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


import java.util.concurrent.TimeUnit


class ApiClient(var context: Context) {

    val instance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = getClient()
            }
            return retrofit!!
        }

    var retrofit: Retrofit? = null
    var gson: Gson? = null

    fun getClient(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            /*.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .header("appVersion", "1.0")
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            }*/
            .build()

        gson = GsonBuilder().create()
        retrofit = Retrofit.Builder()
            .baseUrl(NetSetConstants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit!!
    }
}




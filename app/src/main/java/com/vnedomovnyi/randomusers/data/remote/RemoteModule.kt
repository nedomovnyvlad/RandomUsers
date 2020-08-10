package com.vnedomovnyi.randomusers.data.remote

import com.google.gson.Gson
import com.vnedomovnyi.randomusers.BASE_URL
import com.vnedomovnyi.randomusers.core.data.UserDataSource
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {
    single { provideOkHttpClient() }
    single { Gson() }
    single { provideRetrofit(get(), get()) }
    single { provideUserService(get()) }
    single<UserDataSource> { RemoteUserDataSource(get()) }
}

private fun provideOkHttpClient() =
    OkHttpClient.Builder()
        .build()

private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

private fun provideUserService(retrofit: Retrofit) = retrofit.create(UserService::class.java)
package com.catty.pokemon_tcp_card_1.di

import com.catty.pokemon_tcp_card_1.data.remote.PokeAPI
import com.catty.pokemon_tcp_card_1.repository.PokemonRepositoryImpl
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeAPI
    ) = PokemonRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePokeApi(client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GsonBuildConfig.VERSION)
            .client(client)
            .build()
    }


    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): PokeAPI {
        return retrofit.create(PokeAPI::class.java)
    }

}
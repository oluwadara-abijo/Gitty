package com.dara.gitty.di

import android.app.Application
import android.content.Context
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.data.network.utils.ErrorHandlerImpl
import com.dara.gitty.data.network.utils.StringProvider
import com.dara.gitty.data.network.utils.StringProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @Provides
    fun providesResourceProvider(resourceProvider: StringProviderImpl): StringProvider =
        resourceProvider

    @Provides
    fun provideErrorHandler(errorHandler: ErrorHandlerImpl): ErrorHandler = errorHandler

}

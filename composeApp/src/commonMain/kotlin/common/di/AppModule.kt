package common.di

import org.koin.core.KoinApplication
import org.koin.dsl.module

fun appModule(applicationContext: KoinApplication) = module {
    includes(
        networkModule(applicationContext),
        gatewayModule,
        useCaseModule,
        screenModelsModule
    )
}

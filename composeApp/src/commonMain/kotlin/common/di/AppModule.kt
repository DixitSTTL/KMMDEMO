package common.di

import org.koin.dsl.module

fun appModule() = module {
    includes(
        gatewayModule,
        useCaseModule,
        screenModelsModule
    )
}

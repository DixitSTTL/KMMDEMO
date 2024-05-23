package common.di

import common.util.createData
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun appModule(applicationContext: KoinApplication) = module {
    includes(
        networkModule(applicationContext),
        gatewayModule,
        useCaseModule,
        screenModelsModule
    )
    single{
       val datastore= createData(applicationContext)
        datastore
    }
}

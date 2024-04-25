package common.di


import common.domain.gateway.ILocalConfigurationGateway
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gatewayModule = module {

//    singleOf(::LocalConfigurationGateway) { bind<ILocalConfigurationGateway>() }

}

package common.di


import common.data.gateway.fake.FakeMoreCarsGateway
import common.data.gateway.local.LocalEmployeeGateway
import common.data.gateway.remote.KtorGateway
import common.domain.gateway.IFakeMoreCarsGateway
import common.domain.gateway.IKtorGateway
import common.domain.gateway.ILocaleEmployeeGateway
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gatewayModule = module {

    singleOf(::FakeMoreCarsGateway) { bind<IFakeMoreCarsGateway>() }
    singleOf(::KtorGateway) { bind<IKtorGateway>() }
    singleOf(::LocalEmployeeGateway) { bind<ILocaleEmployeeGateway>() }

}

package common.di


import common.domain.gateway.IFakeMoreCarsGateway
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import common.data.gateway.fake.FakeMoreCarsGateway

val gatewayModule = module {

    singleOf(::FakeMoreCarsGateway) { bind<IFakeMoreCarsGateway>() }

}

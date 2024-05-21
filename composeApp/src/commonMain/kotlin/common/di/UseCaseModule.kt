package common.di


import common.domain.usecase.IManageDashBoardUseCase
import common.domain.usecase.IManageKtorUseCase
import common.domain.usecase.IManageRoomUseCase
import common.domain.usecase.IManageWelcomeUseCase
import common.domain.usecase.ManageDashBoardUseCase
import common.domain.usecase.ManageKtorUseCase
import common.domain.usecase.ManageRoomUseCase
import common.domain.usecase.ManageWelcomeUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::ManageWelcomeUseCase) { bind<IManageWelcomeUseCase>() }
    singleOf(::ManageDashBoardUseCase) { bind<IManageDashBoardUseCase>() }
    singleOf(::ManageKtorUseCase) { bind<IManageKtorUseCase>() }
    singleOf(::ManageRoomUseCase) { bind<IManageRoomUseCase>() }

}

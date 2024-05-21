package common.di

import common.presentation.dashboard.DashBoardScreenModel
import common.presentation.detail.DetailScreenModel
import common.presentation.ktorDemo.KtorScreenModel
import common.presentation.roomDemo.RoomScreenModel
import common.presentation.welcome.WelcomeScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val screenModelsModule = module {
    factoryOf(::WelcomeScreenModel)
    factoryOf(::DashBoardScreenModel)
    factoryOf(::DetailScreenModel)
    factoryOf(::RoomScreenModel)
    factoryOf(::KtorScreenModel)

}

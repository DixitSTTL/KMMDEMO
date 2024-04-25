package common.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import common.presentation.welcome.WelcomeScreenModel
import common.presentation.dashboard.DashBoardScreenModel



val screenModelsModule = module {
    factoryOf(::WelcomeScreenModel)
    factoryOf(::DashBoardScreenModel)

}

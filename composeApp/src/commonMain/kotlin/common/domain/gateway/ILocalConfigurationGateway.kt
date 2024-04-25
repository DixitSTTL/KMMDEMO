package common.domain.gateway

import kotlinx.coroutines.flow.Flow

interface ILocalConfigurationGateway {

    suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean)
    suspend fun getIsFirstTimeUseApp(): Boolean



}

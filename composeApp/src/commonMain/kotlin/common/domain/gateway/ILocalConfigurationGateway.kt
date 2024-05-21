package common.domain.gateway

interface ILocalConfigurationGateway {

    suspend fun saveIsFirstTimeUseApp(isFirstTimeUseApp: Boolean)
    suspend fun getIsFirstTimeUseApp(): Boolean


}

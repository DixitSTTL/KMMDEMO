package common.domain.usecase

import common.data.gateway.remote.KtorGateway


interface IManageKtorUseCase {
    suspend fun getContinents(): List<String>

}

class ManageKtorUseCase(var ktorGateway: KtorGateway) : IManageKtorUseCase {
    override suspend fun getContinents(): List<String> = ktorGateway.getContinents()
}
package common.domain.gateway

interface IKtorGateway {

    suspend fun getContinents(): List<String>
}
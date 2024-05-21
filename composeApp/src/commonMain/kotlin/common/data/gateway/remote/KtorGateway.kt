package common.data.gateway.remote

import common.domain.gateway.IKtorGateway
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorGateway(var client: HttpClient) : IKtorGateway {
    override suspend fun getContinents(): List<String> {

        return client.get("definitions/continents").body<List<String>>()
    }
}
package dev.jonaz.cloud.internal.util.socket

import dev.jonaz.cloud.internal.event.socket.SocketAddServerEvent
import dev.jonaz.cloud.internal.event.socket.SocketRemoveServerEvent
import dev.jonaz.cloud.internal.event.socket.SocketWelcomeEvent
import dev.jonaz.cloud.internal.model.socket.SocketEventModel

class SocketHandler(
    private val message: String
) {

    fun allocate() {
        val request = SocketParser(message).fromJson<SocketEventModel>()

        when (request.event) {
            "welcome" -> SocketWelcomeEvent().execute()
            "addServer" -> SocketAddServerEvent(request.data).execute()
            "removeServer" -> SocketRemoveServerEvent(request.data).execute()
            else -> return
        }
    }
}

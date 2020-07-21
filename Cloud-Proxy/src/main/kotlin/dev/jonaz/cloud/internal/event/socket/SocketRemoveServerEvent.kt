package dev.jonaz.cloud.internal.event.socket

import dev.jonaz.cloud.internal.model.socket.SocketRemoveServerModel
import dev.jonaz.cloud.internal.util.proxy.ServerManager
import dev.jonaz.cloud.internal.util.socket.SocketParser

class SocketRemoveServerEvent(
    message: String
) {
    private val data = SocketParser(message).fromJson<SocketRemoveServerModel>()

    fun execute() {
        ServerManager().remove(
            data.name
        )
    }
}

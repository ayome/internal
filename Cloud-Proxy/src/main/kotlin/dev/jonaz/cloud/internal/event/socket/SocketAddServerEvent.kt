package dev.jonaz.cloud.internal.event.socket

import dev.jonaz.cloud.internal.model.socket.SocketAddServerModel
import dev.jonaz.cloud.internal.util.proxy.ServerManager
import dev.jonaz.cloud.internal.util.socket.SocketParser
import java.net.InetSocketAddress

class SocketAddServerEvent(
    message: String
) {
    private val data = SocketParser(message).fromJson<SocketAddServerModel>()

    fun execute() {
        ServerManager().add(
            data.name,
            InetSocketAddress("host.docker.internal", data.port),
            data.name,
            false
        )
    }
}

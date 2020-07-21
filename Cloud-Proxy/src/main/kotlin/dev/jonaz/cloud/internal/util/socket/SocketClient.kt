package dev.jonaz.cloud.internal.util.socket

import java.net.Socket
import kotlin.concurrent.thread


class SocketClient {
    companion object {
        lateinit var client: Socket
    }

    fun connect() {
        client = Socket("host.docker.internal", 7403)
        listen()
    }

    private fun listen() = thread {
        client.getInputStream().bufferedReader().forEachLine { s ->
            SocketHandler(s).allocate()
        }
    }
}

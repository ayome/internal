package dev.jonaz.cloud.internal

import dev.jonaz.cloud.internal.util.socket.SocketClient
import net.md_5.bungee.api.plugin.Plugin

class Main : Plugin() {

    override fun onEnable() {
        SocketClient().connect()
    }
}

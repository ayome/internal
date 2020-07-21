package dev.jonaz.cloud.internal.util.proxy

import net.md_5.bungee.api.ProxyServer
import java.net.InetSocketAddress

class ServerManager {
    private val instance = ProxyServer.getInstance()

    fun add(name: String, address: InetSocketAddress, motd: String, restricted: Boolean) {
        println("test")
        val construct = instance.constructServerInfo(name, address, motd, restricted)
        instance.servers.put(name, construct)
    }

    fun remove(name: String) {
        println("test2")
        ProxyServer.getInstance().servers.remove(name)
    }
}

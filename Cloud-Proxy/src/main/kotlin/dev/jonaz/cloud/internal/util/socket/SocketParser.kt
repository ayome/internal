package dev.jonaz.cloud.internal.util.socket

import com.google.gson.Gson

class SocketParser(
    val message: String
) {

    inline fun <reified T> fromJson(): T {
        return Gson().fromJson(message, T::class.java)
    }
}

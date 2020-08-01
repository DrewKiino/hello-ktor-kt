package co.hello.ktor.app

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.DefaultHeaders
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            embeddedServer(
                Netty,
                host = "0.0.0.0",
                port = 8080,
                module = Application::client
              ).apply {
                start(wait = true)
              }
        }
    }
}

fun Application.client(
) {
  install(DefaultHeaders)
  install(Routing) {
    get("/") {
      call.respond("Hello Ktor!")
    }
  }
}

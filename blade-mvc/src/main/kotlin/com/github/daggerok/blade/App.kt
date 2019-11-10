package com.github.daggerok.blade

import com.blade.Blade
import com.blade.mvc.RouteContext
import com.blade.mvc.handler.RouteHandler

fun main() {
    Blade.of()
            .get("/api/json", RouteHandler {
                println("json")
                it.json(mapOf("hello" to "world"))
            })
            .get("/api/html", RouteHandler {
                println("html")
                it.html("""<p>Hello!</p>""")
            })
            .get("/api/text", RouteHandler {
                println("text")
                it.text("this is a text...")
            })
            .get("/*", RouteHandler {
                println("ololo trololo")
                it.render("render.html")
            })
            .start()
}

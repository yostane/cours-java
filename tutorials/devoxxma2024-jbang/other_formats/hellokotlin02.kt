///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.fusesource.jansi:jansi:2.4.1

import org.fusesource.jansi.Ansi.*
import org.fusesource.jansi.Ansi.Color.*
import org.fusesource.jansi.AnsiConsole

public fun main() {
    AnsiConsole.systemInstall()
    println(
        ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" DevoxxMA ").fg(RED).a("2024").reset()
    )
    println(ansi().eraseScreen().render("@|red JBang|@ @|green 💖 Kotlin|@"))
}

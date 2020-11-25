package com.zp4rker.yasir

import com.zp4rker.disbot.Bot
import com.zp4rker.disbot.bot
import net.dv8tion.jda.api.requests.GatewayIntent

/**
 * @author zp4rker
 */

fun main(args: Array<String>) {
    bot {
        name = "Yasir's Bot"
        version = Bot::class.java.`package`.implementationVersion

        token = args[0]
        prefix = args[1]

        intents = GatewayIntent.ALL_INTENTS
        cacheEnabled = true

        commands = arrayOf(MuteCommand, UnmuteCommand)
    }
}
package com.zp4rker.yasir

import com.zp4rker.disbot.command.Command
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.TextChannel
import java.util.concurrent.TimeUnit

/**
 * @author zp4rker
 */
object MuteCommand : Command(aliases = arrayOf("mute"), permission = Permission.ADMINISTRATOR) {

    override fun handle(args: Array<String>, message: Message, channel: TextChannel) {
        val member = message.member!!

        if (member.voiceState?.inVoiceChannel() == true) {
            val voiceChannel = member.voiceState?.channel!!
            if (args.isEmpty()) {
                voiceChannel.members.forEach { voiceChannel.guild.mute(it, true).complete() }
                message.addReaction("\u2705").queue()
            } else if (message.mentionedMembers.isNotEmpty()) {
                voiceChannel.guild.mute(message.mentionedMembers[0], true).queue()
                message.addReaction("\u2705").queue()
            }
        } else {
            message.addReaction("\u274c").queue()
        }

        message.delete().queueAfter(3, TimeUnit.SECONDS)
    }

}
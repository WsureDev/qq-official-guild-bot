package top.wsure.guild.bot.official.dtos.operation

import kotlinx.serialization.Serializable

@Serializable
data class IdentifyConfig(
    val token: String,
    val intents: Intents = Intents(),
    val shards: Int = 1,
    val index: Int = 0,
    val properties: Properties = Properties()
) {
    fun toIdentifyOperationData(): IdentifyOperationData {
        return IdentifyOperationData(
            intents = intents.toIntentsValue(),
            properties = properties,
            shard = mutableListOf(index, shards),
            token = token
        )
    }
}

@Serializable
data class Intents(
    val guilds: Boolean = true,
    val guildMembers: Boolean = true,
    val directMessage: Boolean = false,
    val audioAction: Boolean = true,
    val atMessages: Boolean = true,
) {
    fun toIntentsValue(): Long {
        return ((if (guilds) 1.shl(0) else 0)
                + (if (guildMembers) 1.shl(1) else 0)
                + (if (directMessage) 1.shl(12) else 0)
                + (if (audioAction) 1.shl(29) else 0)
                + (if (atMessages) 1.shl(30) else 0))
            .toLong()
    }
}
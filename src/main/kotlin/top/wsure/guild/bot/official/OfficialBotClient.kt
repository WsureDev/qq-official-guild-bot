package top.wsure.guild.bot.official

import top.wsure.guild.bot.common.WsBotClient
import top.wsure.guild.bot.official.dtos.operation.IdentifyConfig
import top.wsure.guild.bot.official.intf.OfficialBotEvent

open class OfficialBotClient(
    config: IdentifyConfig,
    officialEvents:List<OfficialBotEvent> = emptyList(),
    wsUrl :String = "wss://api.sgroup.qq.com/websocket",

    ) : WsBotClient<OfficialBotListener>(
    wsUrl = wsUrl,
    OfficialBotListener(config,officialEvents)
)
package dev.barabu.botcommon;

import dev.barabu.botcommon.model.BotRequest;
import dev.barabu.botcommon.model.BotResponse;

interface IBot {
    BotResponse upperCase(in BotRequest botRequest);
    BotResponse lowerCase(in BotRequest botRequest);
    BotResponse greeting(in BotRequest botRequest);
}
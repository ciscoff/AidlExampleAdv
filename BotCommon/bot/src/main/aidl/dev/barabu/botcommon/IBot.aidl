package dev.barabu.botcommon;

import dev.barabu.botcommon.model.BotRequest;
import dev.barabu.botcommon.model.BotResponse;

interface IBot {
    BotResponse upperCase(in BotRequest botRequest);
    BotResponse lowerCase(in BotRequest botRequest);
    BotResponse greeting(in BotRequest botRequest);

    const String PACKAGE_NAME = "dev.barabu.botservice";
    const String SERVICE_CLASS_NAME = "dev.barabu.service.BotService";
}
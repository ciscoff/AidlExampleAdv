package dev.barabu.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dev.barabu.botcommon.IBot
import dev.barabu.botcommon.model.BotRequest
import dev.barabu.botcommon.model.BotResponse

class BotService : Service() {

    private val binder = object : IBot.Stub() {
        override fun upperCase(botRequest: BotRequest?): BotResponse {
            val request = botRequest ?: return BotResponse(EMPTY_RESPONSE)
            return BotResponse("${request.firstName} ${request.lastName}".uppercase())
        }

        override fun lowerCase(botRequest: BotRequest?): BotResponse {
            val request = botRequest ?: return BotResponse(EMPTY_RESPONSE)
            return BotResponse("${request.firstName} ${request.lastName}".lowercase())
        }

        override fun greeting(botRequest: BotRequest?): BotResponse {
            val request = botRequest ?: return BotResponse(EMPTY_RESPONSE)
            return BotResponse("Hello, ${request.firstName} ${request.lastName}")
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    companion object {
        const val EMPTY_RESPONSE = "empty response"
    }
}
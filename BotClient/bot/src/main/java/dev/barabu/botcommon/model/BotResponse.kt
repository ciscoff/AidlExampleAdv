package dev.barabu.botcommon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BotResponse(val data: String) : Parcelable

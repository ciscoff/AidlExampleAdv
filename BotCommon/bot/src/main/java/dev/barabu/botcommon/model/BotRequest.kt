package dev.barabu.botcommon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BotRequest(val firstName: String, val lastName: String) : Parcelable

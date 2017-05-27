package me.virtualpain.munny.helpers

import android.util.Log
import me.virtualpain.munny.BuildConfig

fun loggerTag(tag: String = BuildConfig.APPLICATION_ID): String
{
    return tag
}

fun debug(message: String, tag: String = loggerTag())
{
    Log.d(tag, message)
}
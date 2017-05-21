package me.virtualpain.munny.helpers

import me.virtualpain.munny.BuildConfig

fun loggerTag(tag: String = BuildConfig.APPLICATION_ID): String
{
    return tag
}
package me.virtualpain.munny

import kotlin.reflect.KClass

data class MainMenuModel(val name: String, val className: KClass<*>, val description: String = "")
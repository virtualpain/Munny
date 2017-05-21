package me.virtualpain.munny.helpers

import java.security.SecureRandom

fun randomNumber(min: Int, max: Int): Int
{
    if (min == max || max < min)
    {
        throw IllegalArgumentException("Yo dumbass, your argument sucks!")
    }

    val random = SecureRandom()

    return random.nextInt(max - min) + min
}
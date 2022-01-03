package dev.mrbergin

import dev.mrbergin.playground.food.common.msg
import dev.mrbergin.playground.food.common.secondMsg
import dev.mrbergin.playground.food.recipe.bar

fun foo() = bar {
    foo = "Hello"
    blah = msg {
        blah = secondMsg {
            blah = 42
        }

    }
}
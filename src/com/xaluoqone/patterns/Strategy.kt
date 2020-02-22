package com.xaluoqone.patterns

/**
 * kotlin 利用高阶函数优化策略模式
 */

val breaststroke = {
    println("我会蛙泳...")
}

val backstroke = {
    println("我会仰泳...")
}

val freestyle = {
    println("我会自由泳...")
}

class Swimmer(val swimming: () -> Unit) {
    fun swim() {
        swimming()
    }
}

fun main() {
    val weekendShaw = Swimmer(freestyle)
    weekendShaw.swim()
    val weekdaysShaw = Swimmer(breaststroke)
    weekdaysShaw.swim()
}
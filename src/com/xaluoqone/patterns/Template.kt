package com.xaluoqone.patterns

/**
 * kotlin 利用高阶函数优化模板模式
 */
class CivicCenterTask {
    fun execute(askForHelp: () -> Unit) {
        lineUp()
        askForHelp()
        evaluate()
    }

    private fun lineUp() {
        println("排队取号")
    }

    private fun evaluate() {
        println("评价服务态度")
    }
}

val pullSocialSecurity = {
    println("办理社保")
}

val applyForCitizenCard = {
    println("申请公民卡")
}

fun main() {
    //测试模板模式
    CivicCenterTask().execute(pullSocialSecurity)
    CivicCenterTask().execute(applyForCitizenCard)
}
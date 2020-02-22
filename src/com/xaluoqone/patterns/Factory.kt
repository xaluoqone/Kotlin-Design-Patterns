package com.xaluoqone.patterns

/**
 * kotlin 普通工厂模式
 */

interface Computer {
    val cpu: String

    companion object {
        operator fun invoke(type: ComputerType) = when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType {
    PC, Server
}

/**
 * kotlin 抽象工厂模式
 */

interface Computer2

class Dell : Computer2
class Asus : Computer2
class Acer : Computer2

class DellFactory : AbstractFactory() {
    override fun produce() = Dell()
}

class AsusFactory : AbstractFactory() {
    override fun produce() = Asus()
}

class AcerFactory : AbstractFactory() {
    override fun produce() = Acer()
}

abstract class AbstractFactory {
    abstract fun produce(): Computer2

    companion object {
        inline operator fun <reified T : Computer2> invoke() = when (T::class) {
            Dell::class -> DellFactory()
            Asus::class -> AsusFactory()
            Acer::class -> AcerFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

fun main() {
    //普通工厂模式测试
    println(Computer(ComputerType.PC).cpu)
    //抽象工厂模式测试
    println(AbstractFactory<Dell>().produce())
}
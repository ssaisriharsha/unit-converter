package com.ssaisriharsha.unitconverter

abstract class UnitTo {
    abstract fun cm(): Double
    abstract fun m(): Double
    abstract fun km(): Double
    abstract fun mm(): Double
}

class CmTo(private val value: String): UnitTo() {
    override fun cm(): Double {
        return value.toDouble()
    }
    override fun m(): Double {
        return value.toDouble() * 0.01
    }
    override fun km(): Double {
        return value.toDouble() * 0.00001
    }
    override fun mm(): Double {
        return value.toDouble() * 10
    }
}

class MTo(private val value: String): UnitTo() {
    override fun cm(): Double {
        return value.toDouble() * 100
    }
    override fun m(): Double {
        return value.toDouble()
    }
    override fun km(): Double {
        return value.toDouble() * 0.001
    }
    override fun mm(): Double {
        return value.toDouble() * 1000
    }
}

class KmTo(private val value: String): UnitTo() {
    override fun cm(): Double {
        return value.toDouble() * 1000 * 100
    }
    override fun m(): Double {
        return value.toDouble() * 1000
    }
    override fun km(): Double {
        return value.toDouble()
    }
    override fun mm(): Double {
        return value.toDouble() * 1000 * 1000
    }
}

class MmTo(private val value: String): UnitTo() {
    override fun cm(): Double {
        return value.toDouble() * 0.1
    }
    override fun m(): Double {
        return value.toDouble() * 0.01 * 0.1
    }
    override fun km(): Double {
        return value.toDouble() * 0.00001 * 0.1
    }
    override fun mm(): Double {
        return value.toDouble()
    }
}
package com.purang.justdoit.java

import java.util.*

//被观察者
class House(var price: Double) : Observable() {
    fun set(price: Double) {
        println("setter $price")
        if (this.price != price) {
            this.price = price
            setChanged()
            this.notifyObservers(price)
        }
    }


    override fun toString(): String {
        return "当前 House(price=$price)"
    }
}

// 观察者
class Customer : Observer {
    private var name = ""

    constructor(name: String) {
        this.name = name
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is House) {
            println("购房者$name:观察到房价变化为：$arg")
        }
    }
}
package com.purang.justdoit

import android.util.SparseArray
import com.purang.justdoit.java.Customer
import com.purang.justdoit.java.Friut
import com.purang.justdoit.java.House
import org.junit.Test

class KtText {

    @Test
    fun test() {
        val house = House(10000.00)
        var customerA = Customer("张三")
        var customerB = Customer("栗色")
        var customerC = Customer("旺旺")

        house.addObserver(customerA)
        house.addObserver(customerB)
        house.addObserver(customerC)

        println(house)
        house.set(6000.00)
    }

    @Test
    fun sparseTest() {

        val sparseArray = SparseArray<Friut>()
        sparseArray.put(1, Friut(100.00))
        sparseArray.put(2, Friut(200.00))
        sparseArray.put(3, Friut(300.00))
        sparseArray.put(1, Friut(100.00))
        println("sparseArray size:" + sparseArray.size())
        println("key=1 price=" + sparseArray.get(1).price)
        println("key=2 price=" + sparseArray.get(2).price)
        println("key=3 price=" + sparseArray.get(3).price)
    }
}
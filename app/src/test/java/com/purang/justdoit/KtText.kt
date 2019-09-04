package com.purang.justdoit

import android.util.SparseArray
import com.purang.justdoit.java.Customer
import com.purang.justdoit.java.Friut
import com.purang.justdoit.java.House
import org.junit.Test
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicInteger

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
        val person = Person("Hello", 23)
        val weakRefPerson = WeakReference<Person>(person)
        var i = 0
        while (true) {
            i++
            if (weakRefPerson.get() != null) {
                println("person 还未回收 i:$i")
            } else {
                println("person已回收")
                break
            }
        }
    }

//    var tmp = 0
    var tmp = AtomicInteger(2)
    @Test
    fun atomicIntegerTest() {

        val thread1 = object : Thread(){
            override fun run() {
                super.run()
                for (i in 0 until 1000000) {
//                    tmp++
                    tmp.incrementAndGet()
                }
            }
        }

        val thread2 = object : Thread(){
            override fun run() {
                super.run()
                for (i in 0 until 1000000) {
//                    tmp++
                    tmp.incrementAndGet()
                }
            }
        }
        val thread3 = object : Thread(){
            override fun run() {
                super.run()
                for (i in 0 until 1000000) {
//                    tmp++
                    tmp.incrementAndGet()
                }
            }
        }

        thread1.start()
        thread2.start()
        thread3.start()
        thread1.join()
        thread2.join()
        thread3.join()
        println("最终值为：$tmp")
    }

    @Test
    fun KtArrayTest() {
        val array = arrayOf("1", 5, 6, 8)
        println(array[2])
        println(array.component2())
        array.reverse() //反转
        for (e in array) {
            print("$e \t")
        }
    }

    @Test
    fun KtListOrSetOrMapTest() {
        //kt 中集合分为可变和不可变集合
        val array = arrayOf(1, 2, 3, "4", "5")
        val list1 = listOf(1, 2, "3", 4)
        val list2 = listOf<String>("a", "b", "c", "d") //确定类型集合
        val list3 = listOf(array)


    }
}
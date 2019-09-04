package com.purang.justdoit


import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicInteger

class Test {


    @org.junit.Test
    fun test() {


        val thread = object : Thread() {
            override fun run() {
                super.run()
            }
        }


        val atomicInteger = AtomicInteger(0)


    }

}

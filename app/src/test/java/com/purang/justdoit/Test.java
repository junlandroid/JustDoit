package com.purang.justdoit;

import android.util.SparseArray;
import com.purang.justdoit.java.Friut;

public class Test {


    @org.junit.Test
    public void test() {

        SparseArray<Object> sparseArray = new SparseArray<>();

        sparseArray.put(1, new Friut(100.00));

        System.out.println("sparseArray:" + sparseArray.get(1));

    }

}

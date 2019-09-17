package com.purang.justdoit.java;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.purang.justdoit.R;

import java.util.Observable;
import java.util.Observer;

public class Test {


    private static final String TAG = Test.class.getSimpleName();
    class Hosse extends Observable{

        private double price;
        private int age;
        private String name;

        public Hosse(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if (this.price != price) {
                this.price = price;
                setChanged();
                this.notifyObservers(price);
            }
        }

        public Hosse(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Hosse{" +
                    "price=" + price +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class Customer implements Observer{

        @Override
        public void update(Observable o, Object arg) {

        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

    class MyActivity extends AppCompatActivity{
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//            RecyclerView recyclerView = findViewById(R.id.recyclerView);


        }
    }

    public static void main(String[] args) {
        System.out.println("-10.4的绝对值是："+Math.abs(-10.4));
    }

}

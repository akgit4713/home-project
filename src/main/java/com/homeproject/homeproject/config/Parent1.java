package com.homeproject.homeproject.config;



public class Parent1 {

    class Parent{
        static void show(){
            System.out.println("parent show");
        }
    }
    static class Child {
        public static void show(){
            System.out.println("test show");
        }
    }

    public void main(String[] args) {
        Parent.show();
    }
}

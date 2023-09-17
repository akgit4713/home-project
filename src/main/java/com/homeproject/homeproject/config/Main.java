//package com.homeproject.homeproject.config;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//class M{
//
//}
//
//
//public class Main {
//
//    static class Parent{
//        M m1 = new M();
//
//        @Override
//        public String toString(){
//            return "I am a parent";
//        }
//
//    }
//    static class Child extends Parent implements Cloneable{
//        public String name;
//        @Override
//        public String toString(){
//            return ("I am a child "+name);
//        }
//
//        public Object clone()  throws CloneNotSupportedException{
//            return super.clone();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        List<Parent> children = new ArrayList<>();
//        List<? extends Parent> parent = new ArrayList<Child>();
//        Parent p = new Child(); // This only works on objects not on array list
//        parent = children;
//        children.add(new Child());
//        show(parent);
////
////        Integer a = 10;
////        Integer b = a;
////        a=20;
////        System.out.println(a);
////        System.out.println(b);;
////        Child c1 = new Child(),c2 = new Child();
////        c1.name = "Utkarsh";
////        try{
////            c2=(Child) c1.clone();
////        }catch (Exception e){
////
////        }
////
////        c1.name = "Anurag";
////
////        System.out.println("c1 : "+c1);
////        System.out.println("c2 : "+c2);
//
//    }
//
//    public static void show(List<? extends Parent> p){
//        for(Parent x : p){
//            System.out.println(x);
//        }
//    }
//}

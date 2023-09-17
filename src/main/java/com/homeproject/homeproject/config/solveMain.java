package com.homeproject.homeproject.config;
//
//import java.util.*;
//
//import static java.lang.Math.abs;
//
//public class solveMain {
//    public static List<String> solve(String[] a, String[] b) {
//        int n = a.length;
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (a[i].length() != b[i].length()) {
//                result.add("NO");
//            } else {
//                int[] cnt1 = new int[26], cnt2 = new int[26];
//                for (int j = 0; j < a[i].length(); j++) {
//                    ++cnt1[a[i].charAt(j) - 'a'];
//                    ++cnt2[b[i].charAt(j) - 'a'];
//                }
//                boolean ok = true;
//                for (int j = 0; j < 26; j++) {
//                    ok &= abs(cnt1[j] - cnt2[j]) <= 3;
//                }
//                result.add(ok ? "YES" : "NO");
//            }
//        }
//        return result;
//    }
//
//    public static void solve2(List<Integer> list) {
//        list.sort((Integer a, Integer b) -> {
//            int cnta = 0, cntb = 0;
//            for (int i = 0; i < 31; i++) {
//                if ((a >> i & 1) != 0)
//                    ++cnta;
//                if ((b >> i & 1) != 0)
//                    ++cntb;
//
//            }
//            if (cnta == cntb) {
//                return a.compareTo(b);
//            } else {
//                if (cnta > cntb)
//                    return 1;
//                else
//                    return -1;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        String[] a = {"aabaab", "aaaaabb"};
//        String[] b = {"bbabbc", "abb"};
//        List<Integer> lst = new ArrayList<>();
//        lst.add(7);
//        lst.add(8);
//        lst.add(6);
//        lst.add(5);
//        System.out.println(solve(a, b));
//        solve2(lst);
//        System.out.println(lst);
//    }
//
//    public static void test1(){
//
//    }
//
//}


public class solveMain{
    //  private
    String var1;
    static String var2;
//
//    solveMain(){
//        M m = new M();
//    }

    public void showVars1(){
        //  display only non static var
        System.out.println("var1 : "+var1);
    }

    public void showVars2(){
        //  display only static var
        System.out.println("var2 : "+var2);
    }

    public void showVars3(){
        //  display both static and non static vars
        System.out.println("var1 : "+var1);
        System.out.println("var2 : "+var2);
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }
    public void setVar2(String var1) {
        var2 = var1;
    }

    public static String getVar2() {
//        System.out.println("var1 "+var1);
        return var2;
    }

    /**
     *
     *
     * Non static inner class require instatitaion of outer class
     */
    public static void main(String[] args) {
        Parent1.Parent p = new Parent1().new Parent();// we need to instantiate this as we can only access static inner classes from outer class

        Parent1.Child c = new Parent1.Child();
    }
}
package com.example.admin.dialog;

/**
 * Created by admin on 2017/7/5.
 */

public class OutterClassTest {
    private int a;
    public int b;
    private static int c;
    public static int d;

    class InnerClass2 {
        int e;
        private void filed1() {
            e = a;
            e = b;
            e = c;
            e = d;
        }
    }

    static class InnerClass1 {
        int f;
        private void filed2() {
            f = c;
            f = d;
        }
    }


}

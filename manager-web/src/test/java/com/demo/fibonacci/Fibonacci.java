package com.demo.fibonacci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ZeMing Zhu
 * @date Create in 2020/12/29 14:55
 * @description Fibonacci
 */
public class Fibonacci {

    @Test
    public void test() {
        int[] fibonacciArray = fibonacciFor(30);
        System.out.println(Arrays.toString(fibonacciArray));
        int[] array = new int[30];
        fibonacciRecursive(array, 0);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 循环
     *
     * @param length 数组长度
     * @return fib数组
     */
    public static int[] fibonacciFor(int length) {
        int[] array = new int[length];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    /**
     * 递归
     *
     * @param array 数组
     * @param index 起始位置
     */
    public static void fibonacciRecursive(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        if (index < 2) {
            array[index] = index;
        } else {
            array[index] = array[index - 1] + array[index - 2];
        }
        fibonacciRecursive(array, index + 1);
    }
}

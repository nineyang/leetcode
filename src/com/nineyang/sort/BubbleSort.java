package com.nineyang.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 俩俩比较，只要后面的小就交换
 */
public class BubbleSort {

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 4, 7};
        sort(test);
    }
}

package com.nineyang.sort;

import java.util.Arrays;

/**
 * 归并算法，分而治之
 */
public class MergeSort {

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(nums, left, middle);
        sort(nums, middle + 1, right);

        merge(nums, left, middle, right);
    }

    private static void merge(int[] nums, int left, int middle, int right) {
        int[] tmp = new int[nums.length];
        int r1 = middle + 1;
        int tIndex = left;
        int cIndex = left;
        while (left <= middle && r1 <= right) {
            if (nums[left] <= nums[r1])
                tmp[tIndex++] = nums[left++];
            else
                tmp[tIndex++] = nums[r1++];
        }
        // 将左边剩余的归并
        while (left <= middle) {
            tmp[tIndex++] = nums[left++];
        }
        // 将右边剩余的归并
        while (r1 <= right) {
            tmp[tIndex++] = nums[r1++];
        }
        while (cIndex <= right) {
            nums[cIndex] = tmp[cIndex];
            //输出中间归并排序结果
            cIndex++;
        }

    }

    public static void main(String[] args) {
        int[] test = {3, 5, 2, 7, 4, 2};
        sort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}

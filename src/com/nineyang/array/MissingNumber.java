package com.nineyang.array;

/**
 * title:0～n-1中缺失的数字(easy)
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * e.g:输入: [0,1,3] 输出: 2
 */
public class MissingNumber {

    /**
     * 要么nums[i] == i，要么nums[i] != i，而数据本身是有序且唯一的，可以转化为一个二分查找
     * @param nums
     * @return
     */
    private static int solution(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(solution(test));
    }
}

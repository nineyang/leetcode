package com.nineyang.array;

/**
 * 最长连续递增序列(easy)
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 */
public class FindLengthOfLCIS {

    private static int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                count++;
                continue;
            }
            if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 4, 7};
        System.out.println(solution(test));
    }
}

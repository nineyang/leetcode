package com.nineyang.array;

/**
 *
 * 高度检查器(easy)
 *
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 *
 *
 */
public class HeightChecker {

    /**
     * 木桶算法
     *
     * @param heights
     * @return
     */
    private static int solution(int[] heights) {
        int[] arr = new int[101];

        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        //arr是一个木桶，>0则证明插入了数据
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                //如果heights传入的数据与当前木桶值不相等，那就意味着位置不对
                if (heights[j++] != i) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] test = {5, 1, 2, 3, 4};
        System.out.println(solution(test));
    }
}

package Leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DailyCode {
    /**
     * LeetCode 1800
     * 最大升序子数组和
     * @param nums
     * @return
     */
    public int maxAscendingSum(int[] nums) {
        List<Integer> sumRecord = new ArrayList<>();
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                currentSum += nums[i];
            }
            else {
                if (nums[i] > nums[i-1]) {
                    currentSum += nums[i];
                }
                else{
                    sumRecord.add(currentSum);
                    currentSum = nums[i];
                }
            }
        }
        sumRecord.add(currentSum);
        return Collections.max(sumRecord);
    }

    public static void main(String[] args) {

    }
}

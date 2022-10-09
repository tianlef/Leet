package Leet;

import sun.security.util.ArrayUtil;

import java.util.*;

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

    /**
     * LeetCode 优势洗牌
     * 10。8
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] record = new int[nums1.length];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> valSet = new LinkedList<>();
        for (int i = 0; i < nums1.length ; i++) {
            int min = Integer.MAX_VALUE;
            int currentIndex = i;
            boolean findIt = false;
            for (int j = index; j < nums2.length; j++) {
                if (set.contains(j)) {
                    continue;
                }
                int different = nums1[i] - nums2[j];
                if (different < min && different > 0 ) {
                    min = different;
                    currentIndex = j;
                    findIt = true;
                }
            }
            if (findIt) {
                set.add(currentIndex);
                record[currentIndex] = nums1[i];
            }
            else{
                valSet.add(nums1[i]);
            }
        }
        for (int i = 0 ; i < nums1.length;i++) {
            if (!set.contains(i)) {
                record[i] = valSet.poll();
            }
        }
        return record;
    }


    /**
     * 字节跳动面试题
     */
    public static void findTheMaxLengthOfStringNotRepeat() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int max = 0;
        int index = 0;
        String current = "";
        for (int i = 0;i < s.length(); i++) {
            Character c = s.charAt(i);
            if (current.contains(c.toString())) {
                if (max < current.length()) {
                    max = current.length();
                }
                current = "";
                for (int j = 0; j < current.length();j++) {
                    if (current.charAt(j) == c) {
                        i = j + index ;
                        break;
                    }
                }
                index = i + 1;
            }
            else {
                current += c;
            }
        }
        if (max < current.length()) {
            max = current.length();
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] h = advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11});
        for(Integer i : h){
            System.out.println(i);
        }
    }
}

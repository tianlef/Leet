package divide_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分治算法LeetCode
 * 1. Pow(x,n)
 * 2. 剑指offer 51 数组中的逆序对
 * 3. 计算右侧小于当前元素的个数(返回数组)
 */
public class DivideConquer {

    public static double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1/x;
        }
        int resultOfDivision = n / 2;
        int reminder = n % 2;
        double halfResult = myPow(x, resultOfDivision);
        if (reminder == 1) {
            return halfResult * halfResult * x;
        }
        else if (reminder == -1) {
            return halfResult * halfResult * 1/x;
        }
        else {
            return halfResult * halfResult;
        }
    }


    /**
     * 分治算法计算逆序对
     * @param nums
     * @return
     */
    public int reverseParis(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[n];

        return reverseParis(copy, 0, n - 1, temp);
    }

    private int reverseParis(int[] copy, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftCount = reverseParis(copy, start, mid, temp);
        int rightCount = reverseParis(copy, mid + 1, end, temp);

        if (copy[mid] <= copy[mid + 1]) {
            return leftCount + rightCount;
        }

        int crossCount = mergeAndCount(copy, start, mid, end, temp);
        return leftCount + rightCount + crossCount;
    }

    private int mergeAndCount(int[] copy, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = copy[i];
        }
        int i = start;
        int j = mid + 1;

        int count = 0;
        for (int k = start; k <= end; k++) {
            if (i == mid + 1) {
                copy[k] = temp[j];
                j++;
            } else if (j == end + 1) {
                copy[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                copy[k] = temp[i];
                i++;
            } else {
                copy[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }


    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] temple = new int[len];
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        countSmaller(0,len-1,copy,temple);
        return res;
    }

    private void countSmaller(int left, int right, int[] copy, int[] temple) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        countSmaller(left,mid,copy,temple);
        countSmaller(mid+1,right,copy,temple);
        if (copy[mid] <= copy[mid+1]) {
            return;
        }
        merge(left,mid,right,copy,temple);
    }

    private void merge(int left, int mid, int right,int[] copy, int[] temple) {
        for (int i = left;i<=right;i++) {

        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-2147483648));
    }
}

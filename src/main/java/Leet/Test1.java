package Leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    /**
     * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
     * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
     * 示例 1：
     * 输入：n = 13
     * 输出：4
     * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
     * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
     * @param args
     */


    public static int test(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int current = i;
            int sum = 0;
            while(current > 0) {
                int c1 = current % 10;
                current = (current - c1)/10;
                sum += c1;
            }
            if (map.containsKey(sum)) {
                map.put(sum,map.get(sum) + 1);
            }
            else{
                map.put(sum,1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        int res = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(test(101));
    }




}

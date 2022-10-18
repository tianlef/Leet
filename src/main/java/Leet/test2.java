package Leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class test2 {

    /**
     * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
     *
     * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
     *
     * 返回 满足这个性质的 s 的任意排列 。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: order = "cba", s = "adcda"
     * 输出: "cbaad"
     * 解释:
     * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
     * 因为“d”不是按顺序出现的，所以它可以在字符串的头尾。“dcbaa”也是有效的输出。
     */
    public static void changeString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c,1);
            }
        }
        for(int i = 0; i < order.length(); i++) {
            int n = map.getOrDefault(order.charAt(i),0);
            for (int j = 0 ; j < n ; j++) {
                System.out.print(order.charAt(i));
            }
            map.remove(order.charAt(i));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            for (int j = 0 ; j < n ; j++) {
                System.out.print(entry.getKey());
            }
        }
    }

    public static void sortString(String order, String s) {
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            characters[i] = s.charAt(i);
        }
        Arrays.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int index1 = order.indexOf(o1+"");
                int index2 = order.indexOf(o2+"");
                return index1 - index2;
            }
        });
        for(Character c : characters) {
            System.out.print(c);
        }

    }


    public static void main(String[] args) {
        sortString("cba","abcda");
    }
}

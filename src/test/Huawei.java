package test;

import com.sun.security.auth.SolarisPrincipal;

import java.util.*;

public class Huawei {

    static final HashMap<Character,Integer> dict = new HashMap<>(
    );

    static {
        dict.put('0',0);
        dict.put('1',1);
        dict.put('2',2);
        dict.put('3',3);
        dict.put('4',4);
        dict.put('5',5);
        dict.put('6',6);
        dict.put('7',7);
        dict.put('8',8);
        dict.put('9',9);
        dict.put('a',10);
        dict.put('b',11);
        dict.put('c',12);
        dict.put('d',13);
        dict.put('e',14);
        dict.put('f',15);
        dict.put('A',10);
        dict.put('B',11);
        dict.put('C',12);
        dict.put('D',13);
        dict.put('E',14);
        dict.put('F',15);
    }


    /**
     * 十六进制转十进制
     * @param s
     * @return
     */
    public static int transfer(String s) {
        String subString = s.substring(2,s.length());
        int result = 0;
        for(int i = 0; i < subString.length(); i++){
            char c = subString.charAt(i);
            int value = dict.get(c);
            result = result * 16 + value;
        }
        return result;
    }

    /**
     * NC61 牛客
     * 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public static ArrayList<Integer> twoSum (ArrayList<Integer> numbers, int target){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> dict = new HashMap();
        for (int i = 0; i <= numbers.size() - 1; i++ ) {
            int key = numbers.get(i);
            int difference = target - key;
            if (dict.keySet().contains(difference)) {
                int index = dict.get(difference);
                res.add(index);
                res.add(i+1);
                return res;
            }
            else {
                dict.put(key,i+1);
            }
        }
        return res;
    }

    /**
     * 明明的随机数
     */
    public static void rondomNumbers() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);
            HashSet<Integer> set = new HashSet<>();
            for (Integer i: list) {
                if (!set.contains(i)){
                    set.add(i);
                    System.out.println(i);
                }
            }
        }
    }


    /**
     * 不同字符串数量
     * @return
     */
    public int characterStatistic() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0 ; i < s.length(); i++) {
            Character c = s.charAt(i);
            characters.add(c);
        }
        return characters.size();
    }

    /**
     * 青蛙跳台阶问题
     * 一只青蛙一次可以跳上一个台阶，或者两个台阶
     * 问跳到第N个台阶有几种跳法
     * @param number
     * @return
     */
    public static int jumpFloor (int number) {
        //用于记录每个台阶有几种跳法
        int[] record = new int[41];
        record[1] = 1;
        record[2] = 2;
        for (int i = 3; i <= number; i++) {
            record[i] = record[i-1] + record[i-2];
        }
        return record[number];
    }

    /**
     * 解析字符指令
     * 按字符移动
     */
    public static void moveByString() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(";");
        int x = 0 ,y = 0;
        for (String s: split) {
            /**
             * 长度判断
             */
            if (s.length() > 3 || s.length() <= 1) {
                continue;
            }
            /**
             * 判断后面是否都为数字
             */
            boolean flag = true;
            for (int i = 1; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (!Character.isDigit(c)) {
                    flag = false;
                }
            }
            if (!flag) {
                continue;
            }
            /**
             * 初始字符判断
             */
            Character first = s.charAt(0);
            int num = Integer.parseInt(s.substring(1));
            if (first == 'A') {
                x -= num;
            }
            else if (first == 'S') {
                y -= num;
            }
            else if (first == 'W') {
                y += num;
            }
            else if (first == 'D') {
                x += num;
            }
        }
        System.out.println(x+","+y);
    }


    /**
     * 删除出现次数最少的字符串
     */
    public void removeString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c) + 1);
            }
            else {
                map.put(c,1);
            }
        }
        int min = 100;
        for (Integer num: map.values()) {
            if (min > num) {
                min = num;
            }
        }
        HashSet<Character> set = new HashSet<>();
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                set.add(entry.getKey());
            }
        }
        for (int i = 0 ; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!set.contains(c)) {
                System.out.print(c);
            }
        }
    }


    /**
     * ip和十进制之间的转换
     */
    public static void IpNum() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(".")) {
                System.out.println(ip2num(line));
            }
            else {
                System.out.println(num2ip(line));
            }
        }
    }

    private static Long ip2num(String line) {
        String[] split = line.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            int num = Integer.parseInt(str);
            String num2 = Integer.toBinaryString(num);
            while (num2.length() < 8) {
                num2 = "0" + num2;
            }
            stringBuilder.append(num2);
        }
        return Long.parseLong(stringBuilder.toString(),2);
    }

    private static String num2ip(String line) {
        Long num = Long.parseLong(line);
        String num2 = Long.toBinaryString(num);
        while(num2.length() < 32) {
            num2 = "0" + num2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i <= 24; i = i + 8){
            String sub = num2.substring(i , i+8);
            int num3 = Integer.parseInt(sub,2);
            stringBuilder.append(num3);
            if (i != 24) {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }



     /**
     * 输入练习
     * @param args
     */
    public static void main(String[] args) {
        IpNum();
    }


}

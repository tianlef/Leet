package test;

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
     * 输入练习
     * @param args
     */
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(transfer(s));
        }
         */
         ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3,2,4));
         System.out.println(twoSum(input,6));




    }


}

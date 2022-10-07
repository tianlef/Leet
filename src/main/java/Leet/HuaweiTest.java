package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HuaweiTest {

    /**
     * 通过率 95%
     * 拼接数组
     * 第一个输入是 每次拼接的数组长度
     * 第二个输入是 有多少个数组
     * 之后是数组的实际输入
     */
    public static void first() {
        Scanner scanner = new Scanner(System.in);
        int splitLength = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<List<String>> record = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            List<String> characters  =  Arrays.asList(line.split(","));
            if (characters.size() > maxLength) {
                maxLength = characters.size();
            }
            record.add(characters);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int first  = 0;
        while(first <= maxLength) {
            for (List<String> strings : record) {
                for (int i = first; i < first+splitLength; i++) {
                    if (i >= strings.size()) {
                        break;
                    }
                    stringBuilder.append(strings.get(i));
                    stringBuilder.append(",");
                }
            }
            first += splitLength;
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length()-1));
    }


    /**
     * 出租车计价问题
     * 出租车每逢4 就会进1
     * 要求算出实际价格
     * 通过率 80%
     */
    public static void second() {
        Scanner scanner = new Scanner(System.in);
        int fake = scanner.nextInt();
        int p = 100000000;
        while( p >= 10) {
            if (fake / p > 0) {
                int n = fake / p ;
                int rid = fake % p;
                if (rid > 4 * (p/10)) {
                    n = n + 1;
                }
                fake -= p/10 * n;
            }
            p = p /10;
        }
        if (fake < 10 && fake > 4) {
            fake -= 1;
        }
        System.out.println(fake);
    }

    /**
     * 字符串匹配问题
     * . 匹配任意一个字符
     * * 可以匹配0个或者任意多个字符
     * 要求判断给定字符串数组有多少个能够匹配当前的模版
     * 通过率 80%
     */
    public static void third() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String rex = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            List<Integer> indexList= new ArrayList<>();
            indexList.add(0);
            boolean canSkip = false;
            for (int j = 0 ; j < rex.length(); j++) {
                Character c = rex.charAt(j);
                if (c == '.') {
                    for(int z = 0; z < indexList.size();z++) {
                        indexList.set(z,indexList.get(z) + 1);
                    }
                    canSkip = false;
                }
                else if (c == '*') {
                    canSkip = true;
                }
                else {
                    if (canSkip == false) {
                        for (int z = 0; z < indexList.size();z++) {
                            int index = indexList.get(z);
                            if (index < s.length()) {
                                Character cInit = s.charAt(index);
                                if (cInit == c) {
                                    indexList.set(z,indexList.get(z) + 1);
                                }
                                else {
                                    indexList.remove(z);
                                }
                            }
                            else {
                                indexList.remove(z);
                            }
                        }
                    }
                    else {
                        int minIndex = s.length() - 1;
                        for(int z = 0 ; z < indexList.size(); z++) {
                            int index = indexList.get(z);
                            if (minIndex > index) {
                                minIndex = index;
                            }
                        }
                        indexList = new ArrayList<>();
                        for (int x = minIndex; x < s.length(); x++) {
                            Character cInit = s.charAt(x);
                            if (c == cInit) {
                                indexList.add(x);
                            }
                        }
                    }
                    canSkip = false;
                }
            }
            if (indexList.size() > 0) {
                stringBuilder.append(i + ",");
            }
        }
        if (stringBuilder.length() > 0) {
            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
        }
        else{
            System.out.println(-1);
        }


    }

    public static void main(String[] args) {
        third();
    }
}

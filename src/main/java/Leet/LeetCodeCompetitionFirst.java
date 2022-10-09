package Leet;

import com.sun.xml.internal.ws.util.StringUtils;

public class LeetCodeCompetitionFirst {
    public static int hardestWorker(int n, int[][] logs) {
        int maxTime = 0;
        int maxId = -1;
        int preEndTime = 0;
        for(int i = 0 ; i < logs.length; i++) {
            int currentId = logs[i][0];
            int endTime = logs[i][1];
            int interval = endTime - preEndTime;
            if (interval > maxTime) {
                maxTime = interval;
                maxId = currentId;
            }
            else if (interval == maxTime) {
                maxId = currentId < maxId ? currentId : maxId;
            }
            preEndTime = endTime;
        }
        return maxId;
    }

    public static int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        res[0] = pref[0];
        int currentRes = res[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = currentRes ^ pref[i];
            currentRes = currentRes ^ res[i];
        }
        return res;
    }

    /**
     * 机器人字符串 这个做错了
     * @param s
     * @return
     */
    public static String robotWithString(String s) {
        int index = 0;
        String res = "";
        while(s.length() > 0){
            index = findMiniumIndex(s);
            String pre = s.substring(0,index+1);
            for (int i = pre.length()-1; i >= 0 ; i--) {
                res += pre.charAt(i);
            }
            s = s.substring(index+1);
        }
        return res;
    }

    public static int findMiniumIndex(String s) {
        Character min = s.charAt(0);
        int index = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < min) {
                index = i;
                min = s.charAt(i);
            }
        }
        return index;
    }



    public static void main(String[] args) {
        //System.out.println(hardestWorker(70,new int[][]{{36,3},{1,5},{12,8},{1,15},{53,11},{29,12},{52,14}}));
        //System.out.println(findArray(new int[]{5,2,0,3,1}));
        //findArray(new int[]{413935,351122});
        System.out.println(robotWithString("bydizfve"));
    }
}

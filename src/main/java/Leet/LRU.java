package Leet;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
     HashMap<Integer, Integer> map;
     int maxThreshold;
     Deque<Integer> keyQueue;

     LRU(int maxThreshold) {
         this.maxThreshold = maxThreshold;
         map = new HashMap<>(this.maxThreshold);
         keyQueue = new LinkedList<>();
    }

    public int get(int key) {
         if (map.containsKey(key)) {
             /**
              * 重排链表中key的位置，需要把key的位置放到链表的最后，并且把key在原链表中删除
              */
             keyQueue.remove(key);
             keyQueue.add(key);
             return map.get(key);
         }
         else {
             return -1;
         }
    }

    public void put(int key, int value) {
         if(map.size() == this.maxThreshold) {
             int deletedKey = keyQueue.remove();
             map.remove(deletedKey);
         }
         map.put(key,value);
         keyQueue.add(key);
    }
}

import java.util.*;
import java.util.PriorityQueue;

public class Solution {

    private class Freq  {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }



    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 最小对 // 生成comparator类
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            public int compare(Freq e1, Freq e2) {
                return e1.freq - e2.freq;
            }
        });

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else {
                if (map.get(key) > pq.peek().freq) {
                    pq.remove();
                    pq.add(new Freq(key, map.get(key)));
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(res.size() - 1, pq.remove().e);

        return res;
    }
}

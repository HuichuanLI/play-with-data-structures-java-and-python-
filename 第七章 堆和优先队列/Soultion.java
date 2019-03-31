import java.util.*;
import java.util.PriorityQueue;

public class Soultion {

    private class Freq implements Comparable<Freq> {
        public  int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq == another.freq)
                return 0;
            else
                return 1;
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
        // 最小对
        PriorityQueue<Freq> pq = new PriorityQueue<>();

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
            res.add(res.size()-1,pq.remove().e);

        return res;
    }
}

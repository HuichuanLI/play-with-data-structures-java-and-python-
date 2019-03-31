import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solustion {


    private class Freq implements Comparable<Freq>{
        int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public  int compareTo(Freq another){
            if(this.freq < another.freq)
                return 1;
            else if(this.freq == another.freq)
                return  0;
            else
                return  -1;
        }
    }
    // nlgk
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num:nums){
           if(map.containsKey(num)){
               map.put(num,map.get(num)+1);
           }else{
               map.put(num,1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();

        for(int key:map.keySet()){
            if(pq.getSize() <k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else{
                if(map.get(key) > pq.getFront().freq){
                    pq.dequeue();
                    pq.enqueue(new Freq(key,map.get(key));
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }
}

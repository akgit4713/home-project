package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cache {

    public Map<String, Node> cache = new HashMap<>();
    public LinkedList<Node> list = new LinkedList<>();

    public static final Integer SIZE = 3;

    static class Node{
        public String key;
        public String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }



    public static void main(String[] args) {
        Cache cache1 = new Cache();
        cache1.addKey("k1","1");
        cache1.addKey("k2","1");
        cache1.addKey("k3","1");
        cache1.addKey("k4","1");
        cache1.addKey("k5","1");
    }


    public void invalidate(){
        if(list.size()>0) {
            cache.remove(list.peek().key); // MRU
            list.removeFirst();
        }
    }

    public String getValue(String key){
        String val = cache.get(key).key;
        List<Node> beg = list.subList(0,list.indexOf(cache.get(key)));
        List<Node> end = list.subList(list.indexOf(cache.get(key)), list.size());
        list.addFirst(cache.get(key));
        list.addAll(beg);
        list.addAll(end);
        return val;
    }

    public void addKey(String key, String value){
        if(cache.size() == SIZE){
            invalidate();
        }
        if(!cache.containsKey(key)){
            Node node = new Node(key, value);
            list.addFirst(node);
            cache.put(key,node);
        }
        else {
            List<Node> beg = list.subList(0, list.indexOf(cache.get(key)));
            List<Node> end = list.subList(list.indexOf(cache.get(key)), list.size());
            list.addFirst(cache.get(key));
            list.addAll(beg);
            list.addAll(end);
        }
    }

    /**
     *
     *
     *    Cache -> singelton
     *    Invalidation -> [LRU,MRU, ...]
     *
     *    InvalidatingStrategy
     *      - invalidate()
     *    - implmented by
     *     LRUStrategy
     *     LFU
     *     ..
     *     ..
     *
     *
     *    InvalidaingFactory -> object of the respective stargtegy
     *    -- getInstance(INvalidation i)
     *          return new (i)
     *
     *     Cache cahe = new Cache(Invalidation)
     *
     *     Cache -> abstract
     *      addKey()
     *      get()
     *      invalidate(Strategy)
     *
     *     LRUCache extends Ccahe{
     *
     *
     *     }
     *
     *     LFU{
     *
     *
     *
     *     }
     *
     *
     *
     *
     *
     *
     *
     *
     */




}

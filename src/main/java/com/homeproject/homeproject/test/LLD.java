//package com.homeproject.homeproject.test;
//
//
//import java.sql.Time;
//import java.util.*;
//
//interface ICache<K,V>{
//    boolean put(K key, V value, Time ttl);
//    V fetch(K key);
//    void evict(K key);
//    void invalidate();
//}
//class Node{
//    String key;
//    String value;
//    Node next;
//    Node prev;
//    public  Node(String key, String value){
//        this.key = key;
//        this.value = value;
//        this.next = null;
//        this.prev = null;
//    }
//
//}
//
//class LRUCache implements ICache{
//    private final Integer limit ;
//    public Map<String, Node> cacheMap = new HashMap<>();
//    public Map<Time, Node> ttlMap = new HashMap<>();
//    Node head = new Node("-1", "-1");
//    Node tail = new Node("-1", "-1");
//
//
//    public LRUCache(Integer limit) {
//        head.next = tail;
//        tail.prev = head;
//        this.limit = limit;
//    }
//
//    private void deleteNode(Node delnode) {
//        Node prevv = delnode.prev;
//        Node nextt = delnode.next;
//
//        prevv.next = nextt;
//        nextt.prev = prevv;
//    }
//
//    private void addNode(Node newnode) {
//        Node temp = head.next;
//
//        newnode.next = temp;
//        newnode.prev = head;
//
//        head.next = newnode;
//        temp.prev = newnode;
//    }
//
//    @Override
//    public boolean put(Object key, Object value, Time ttl) {
//        if (cacheMap.containsKey(key)) {
//            Node curr = cacheMap.get(key);
//            cacheMap.remove(key);
//            deleteNode(curr);
//        }
//
//        if (cacheMap.size() == limit) {
//            cacheMap.remove(tail.prev.key);
//            deleteNode(tail.prev);
//        }
//
//        addNode(new Node((String) key, value));
//        //m.put(key, head.next);
//        return true;
//    }
//
//    @Override
//    public Object fetch(Object key) {
//        Node v = cacheMap.get(key);
//        deleteNode(v);
//        addNode(v);
//        return v.value;
//    }
//
//    @Override
//    public void evict(Object key) {
//        if(cacheMap.containsKey(key)){
//            Node v = cacheMap.get(key);
//            cacheMap.remove(key);
//            deleteNode(v);
//        }
//    }
//
//    @Override
//    public void invalidate() {
//
//    }
//}
//
//public class LLD {
//    public static void main(String[] args) {
//
//
//    }
//}

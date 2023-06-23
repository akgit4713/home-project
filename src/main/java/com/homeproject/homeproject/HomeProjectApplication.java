package com.homeproject.homeproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Collection->Container
 * Collection Framework -> STL
 *
 * 9 key interfaces of Collection Framework
 *
 *
 *                                                                                              Collection
 *
 *
 *                                 List[no duplicates]                                           Set                                                   Queue
 *
 *
 *             ArrayList       LinkedList       Vector                                HashSet               SortedSet                            PriorityQueue               BlockingQueue
 *
 *
 *
 *                                               Stack                              LinkedHashSet         NavigableSet                                                        PriorityBlockingQueue
 *
 *
 *                                                                                                         TreeSet                                                            LinkedBlockingQueue
 */

@SpringBootApplication
public class HomeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeProjectApplication.class, args);
    }

}

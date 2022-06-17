package com.example.huffman;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByValue {


    Map<Character, Integer> sortByValue(boolean order, HashMap<Character, Integer> map) {

        List<Entry<Character, Integer>> list = new LinkedList<Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                if (order) {

                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}
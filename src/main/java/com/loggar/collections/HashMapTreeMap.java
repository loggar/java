package com.loggar.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTreeMap {
    // Driver method to test above method
    public static void main(String[] args) {
        int arr[] = { 10, 34, 5, 10, 3, 5, 10 };
        printFreqHashMap(arr);
        printFreqTreeMap(arr);
    }

    static void printFreqHashMap(int arr[]) {
        System.out.println("This function prints frequencies of all elements: HashMap");
        // Creates an empty HashMap
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            Integer c = hmap.get(arr[i]);

            // If this is first occurrence of element
            if (hmap.get(arr[i]) == null) hmap.put(arr[i], 1);

            // If elements already exists in hash map
            else hmap.put(arr[i], ++c);
        }

        // Print result
        for (Map.Entry<Integer, Integer> m : hmap.entrySet())
            System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
    }

    static void printFreqTreeMap(int arr[]) {
        System.out.println("This function prints frequencies of all elements: TreeMap");
        // Creates an empty TreeMap
        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            Integer c = tmap.get(arr[i]);

            // If this is first occurrence of element
            if (tmap.get(arr[i]) == null) tmap.put(arr[i], 1);

            // If elements already exists in hash map
            else tmap.put(arr[i], ++c);
        }

        // Print result
        for (Map.Entry<Integer, Integer> m : tmap.entrySet())
            System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
    }
}

// For operations like add, remove, containsKey, time complexity is O(log n where n is number of elements present in TreeMap.
// TreeMap always keeps the elements in a sorted(increasing) order, while the elements in a HashMap have no order. TreeMap also provides some cool methods for first, last, floor and ceiling of keys.

// 1. HashMap implements Map interface while TreeMap implements SortedMap interface. A Sorted Map interface is a child of Map.
// 2. HashMap implements Hashing, while TreeMap implements Red-Black Tree(a Self Balancing Binary Search Tree). Therefore all differences between Hashing and Balanced Binary Search Tree apply here.
// 3. Both HashMap and TreeMap have their counterparts HashSet and TreeSet. HashSet and TreeSet implement Set interface. In HashSet and TreeSet, we have only key, no value, these are mainly used to see presence/absence in a set.
// For above problem, we can’t use HashSet (or TreeSet) as we can’t store counts.
// An example problem where we would prefer HashSet (or TreeSet) over HashMap (or TreeMap) is to print all distinct elements in an array.

package com.sviryd.mikhail;

import java.util.ArrayList;
import java.util.List;

/**
 * Precondition:
 *  1. it exists 2 sorted equal-dimensional arrays. Need to add all elements of second to first
 * so that the first stays sorted.
 */
public class MergeSort {
    public void merge(final List<Integer> a, final List<Integer> b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Some of lists is null.");
        }
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Size of lists is not equal.");
        }
        if (a.size() > Integer.MAX_VALUE / 2) {
            throw new IllegalArgumentException("Size of list is bigger that expected.");
        }
        if (a.isEmpty()) {
            return;
        }
        int capacity = a.size();
        int newCapacity = capacity * 2;
        Integer[] c = new Integer[newCapacity];
        int iA, iB, iC;
        iA = 0;
        iB = 0;
        iC = 0;
        int iLast = capacity - 1;
        while (iA <= iLast && iB <= iLast) {
            if (a.get(iA).compareTo(b.get(iB)) < 0) {
                c[iC++] = a.get(iA++);
            } else {
                c[iC++] = b.get(iB++);
            }
        }
//        a.ensureCapacity(newCapacity);
        if (iA < iB) {
            for (int i = iC; i < newCapacity; i++) {
                c[i] = a.get(iA++);
            }
            for (int i = 0; i < capacity; i++) {
                a.set(i, c[i]);
            }
            for (int i = capacity; i < newCapacity; i++) {
                a.add(c[i]);
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                a.set(i, c[i]);
            }
            for (int i = capacity; i < iC; i++) {
                a.add(c[i]);
            }
            for (int i = iC; i < newCapacity; i++) {
                a.add(b.get(iB++));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(2);
        first.add(4);
        first.add(6);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(3);
        second.add(5);
        second.add(7);
        new MergeSort().merge(first, second);
        System.out.println(first);
        System.out.println(second);
    }
}

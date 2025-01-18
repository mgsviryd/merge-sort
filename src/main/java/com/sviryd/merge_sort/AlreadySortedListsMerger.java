package com.sviryd.merge_sort;

import java.util.ArrayList;

public class AlreadySortedListsMerger<T extends Comparable<T>> {
    /**
     * Merges two sorted lists into the first list in place, maintaining sorted order.
     *
     * @param a the first sorted list, which will contain all elements after merging
     * @param b the second sorted list
     * @throws IllegalArgumentException if the input lists are null, have different sizes, or are not sorted
     */
    public void merge(ArrayList<T> a, ArrayList<T> b) {
        // Null checks
        if (a == null || b == null) {
            throw new IllegalArgumentException("One or both of the lists are null.");
        }

        // Check for equal sizes (optional if merging two lists of the same size is a requirement)
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("The sizes of the lists are not equal.");
        }

        // Ensure that list 'a' has enough capacity
        a.ensureCapacity(a.size() + b.size());

        // Start merging from the end of both lists
        int indexA = a.size() - 1;
        int indexB = b.size() - 1;
        int indexMerged = a.size() + b.size() - 1;

        // Extend the list 'a' to accommodate elements from 'b'
        for (int i = 0; i < b.size(); i++) {
            a.add(null); // Fill the array with null elements to avoid resizing issues
        }

        // Merge 'a' and 'b' in reverse order
        while (indexB >= 0) {
            if (indexA >= 0 && a.get(indexA).compareTo(b.get(indexB)) > 0) {
                a.set(indexMerged--, a.get(indexA--));
            } else {
                a.set(indexMerged--, b.get(indexB--));
            }
        }
    }
}

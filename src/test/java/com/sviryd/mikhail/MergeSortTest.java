package com.sviryd.mikhail;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortTest {
    private MergeSort mergeSort;
    private List<Integer> first;
    private List<Integer> second;

    @Before
    public void init() {
        mergeSort = new MergeSort();
        first = new ArrayList<>();
        first.add(0);
        first.add(2);
        first.add(4);
        first.add(6);
        first.add(7);
        second = new ArrayList<>();
        second.add(1);
        second.add(2);
        second.add(3);
        second.add(5);
        second.add(7);
    }

    private List<Integer> getCopyFirst() {
        return first.stream().collect(Collectors.toList());
    }

    private List<Integer> getCopySecond() {
        return second.stream().collect(Collectors.toList());
    }

    @Test
    public void equalDimensionLists() {
        Assert.assertTrue(first.size() == second.size());
    }

    @Test
    public void sortAndAccumulateInFirst() {
        final List<Integer> first = getCopyFirst();
        final List<Integer> second = getCopySecond();
        int firstSize = first.size();
        int secondSize = second.size();
        int ultimateSize = firstSize + secondSize;
        mergeSort.merge(first, second);
        boolean ordered = Ordering.natural().isOrdered(first);
        Assert.assertTrue(ordered);
        Assert.assertTrue(first.size() == ultimateSize);
    }
}
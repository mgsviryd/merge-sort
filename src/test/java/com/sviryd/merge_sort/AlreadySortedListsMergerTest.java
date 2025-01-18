package com.sviryd.merge_sort;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AlreadySortedListsMergerTest {
    private AlreadySortedListsMerger merger;
    private ArrayList<Integer> first;
    private ArrayList<Integer> second;

    @Before
    public void init() {
        merger = new AlreadySortedListsMerger<Integer>();
        first = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 7));
        second = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7));
    }

    @Test
    public void equalSizeLists() {
        Assert.assertEquals(first.size(), second.size());
    }

    @Test
    public void sort() {
        int actualSize = first.size() + second.size();
        merger.merge(first, second);
        Assert.assertTrue(Ordering.natural().isOrdered(first));
        Assert.assertEquals(actualSize, first.size());
    }
}
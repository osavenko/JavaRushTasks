package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators)
        {
            this.comparators = comparators;
        }


        @Override
        public int compare(T o1, T o2)
        {
            for(int i = 0;i<comparators.length;i++){
                if (comparators[i].compare(o1, o2) != 0)
                {
                    return comparators[i].compare(o1, o2);
                } else continue;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<TestClass> list = new ArrayList<>();
        list.add(new TestClass("aaa","bbb","ccc"));
        list.add(new TestClass("bbb","ccc","hrt"));
        list.add(new TestClass("aaa","ccc","aaa"));
        list.add(new TestClass("bbb","ccc","aaa"));
        list.add(new TestClass("bbb","ccc","bbb"));
        list.stream().forEach(System.out::println);
        System.out.println("--------------");
        Collections.sort(list,new CustomizedComparator<TestClass>(new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.f1.compareTo(o2.f1);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.f2.compareTo(o2.f2);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.f3.compareTo(o2.f3);
            }
        }));
        list.stream().forEach(System.out::println);
    }
}

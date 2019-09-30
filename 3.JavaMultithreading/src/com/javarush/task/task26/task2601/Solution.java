package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    /*    Integer[] intA = {10, 12, 19, 25, 4};
        System.out.println(Arrays.toString(sort(intA)));*/

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final float mediana;
        if(array.length%2==0){
            mediana = (array[array.length/2-1]+array[array.length/2])/2f;
        }else{
            mediana = array[array.length/2];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = (int)(Math.abs(o1-mediana)-Math.abs(o2-mediana));
                return res==0?o1-o2:res;
            }
        });
        return array;
    }
}

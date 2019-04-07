package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        int i = 0;
        //напишите тут ваш код. step 3 - пункт 3
        Iterator<Cat> iterator = cats.iterator();
        while(iterator.hasNext()){
            Cat cat = iterator.next();
            if(i==1) iterator.remove();
            i++;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet<Cat> newCat = new HashSet<>();

        newCat.add(new Cat());
        newCat.add(new Cat());
        newCat.add(new Cat());

        return newCat;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for(Cat currentCat:cats){
            System.out.println(currentCat);
        }
    }

    // step 1 - пункт 1
    public static class Cat {

    }
}

package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null) return false;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

        return (n.first != null ? n.first.equals(first) : true) && (n.last != null ? n.last.equals(last) : true);
    }

    @Override
    public int hashCode() {
        int hashF = first!=null?first.hashCode():0;
        int hashL = last!=null?last.hashCode():0;

        return 31*hashF+hashL;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        boolean b = (new Solution(null,"2")).equals(new Solution("1","2"));
        System.out.println("->"+b);
    }
}

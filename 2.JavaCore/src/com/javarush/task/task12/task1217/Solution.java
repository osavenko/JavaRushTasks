package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
    public interface CanFly{
        public int getMaxHeight();
    }
    public interface CanRun{
        public int getMaxDistance();
    }
    public interface CanSwim{
        public int getMaxDepth();
    }
}

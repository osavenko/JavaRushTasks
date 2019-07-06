package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(this.getI(),this.getJ());
        }

        @Override
        public String toString() {
            return "["+this.getClass().getName()+"]"+"{propertis i = "+this.i+", j = "+this.j+"}";
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
            //return new B(this.getI(), this.getJ(), this.getName());
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) {
        B a0 = new B(10,11,"00");
        B a1 = null;
        try {
            a1= (B) a0.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Error");
        }
        System.out.println(a0);
        System.out.println(a1);
    }
}

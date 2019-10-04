package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] martix) {
        this.matrix = martix;
    }

    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height+2][width+2];
    }
    public void setPoint(double x, double y, char c){
        int x1 = (int) Math.round(x);
        int y1 = (int) Math.round(y);
        if((x1<0)||(y1<0)||(y1>=matrix.length)||(x1>=matrix[0].length))
            return;
        matrix[y1][x1] = c;
    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        int xx = (int) Math.round(x);
        int yy = (int) Math.round(y);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]!=0) setPoint(xx+j, yy+i,c);
            }
        }
    }
    public void clear(){
        matrix = new char[height+2][width+2];
    }
    public void print(){
        for(char[] line:matrix)
            System.out.println(new String(line));
    }
}

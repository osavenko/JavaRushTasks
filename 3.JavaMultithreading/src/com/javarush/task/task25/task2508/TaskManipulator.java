package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;
    @Override
    public void run() {
        try{
            while (!thread.isInterrupted()){
                thread.sleep(0);
                System.out.println(thread.getName());
                thread.sleep(90);
            }
        }catch (InterruptedException ie){}
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}

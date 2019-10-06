package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
    public static void main(String[] args) throws IOException {

        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int serverPort = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            ConsoleHelper.writeMessage("Сервер запущен...");
            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }
        } catch (IOException e){

        }finally {
            serverSocket.close();
        }
    }
    public static void sendBroadcastMessage(Message message){
        try{
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        }catch (IOException e){
            e.printStackTrace();
            ConsoleHelper.writeMessage("Сообщение не отправлено");
        }
    }
}

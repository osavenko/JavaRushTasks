package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection = null;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("участник " + userName + " присоединился к чату");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("участник " + userName + " покинул чат");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType()!=MessageType.NAME_ACCEPTED
                        &&message.getType()!=MessageType.NAME_REQUEST){
                    throw new IOException("Unexpected MessageType");
                }
                if(message.getType()==MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else{
                    notifyConnectionStatusChanged(true);
                    return;
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {

                Message message = connection.receive();

                switch (message.getType()) {

                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;

                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;

                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;

                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка соединения!");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка");
            return;
        }
        if(clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено."+
                    "Для выхода наберите команду 'exit'.");
            while(clientConnected){
                String message;
                if(!(message=ConsoleHelper.readString()).equals("exit")){
                    if(shouldSendTextFromConsole()){
                        sendTextMessage(message);
                    }
                }else{return;}
            }

        }else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}

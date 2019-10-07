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

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getLocalSocketAddress().toString());
            String userName = null;
            try(Connection connection = new Connection(socket)){
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection,userName);

            }catch (IOException ex){
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException ex){
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            }
            connectionMap.remove(userName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message mess = connection.receive();
                if (mess.getType()==MessageType.USER_NAME){
                    if(mess.getData()!=null&&!mess.getData().isEmpty()){
                        if (connectionMap.get(mess.getData())==null){
                            connectionMap.put(mess.getData(),connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return mess.getData();
                        }
                    }
                }
            }
        }
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(String key:connectionMap.keySet()){
                Message message = new Message(MessageType.USER_ADDED,key);
                if(!key.equals(userName))
                    connection.send(message);
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    String s = userName+": "+message.getData();

                    Message mess = new Message(MessageType.TEXT,s);
                    sendBroadcastMessage(mess);
                }else{
                    ConsoleHelper.writeMessage("Error");
                }
            }
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

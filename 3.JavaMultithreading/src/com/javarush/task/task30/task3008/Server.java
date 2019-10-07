package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getRemoteSocketAddress());
            String clientName = null;
            //Создаем Connection
            try (Connection connection = new Connection(socket)) {
                //Выводить сообщение, что установлено новое соединение с удаленным адресом
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                clientName = serverHandshake(connection);
                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED)
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                //Сообщать новому участнику о существующих участниках
                notifyUsers(connection, clientName);
                //Запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, clientName);

                //После того как все исключения обработаны, удаляем запись из connectionMap
                connectionMap.remove(clientName);
                //и отправлялем сообщение остальным пользователям
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));

                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");

            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            }

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

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }
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

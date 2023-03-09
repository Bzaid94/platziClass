package com.persistence.manager;

import com.persistence.bean.Message;
import com.persistence.sql.MessageDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {
    static Scanner scanner = new Scanner(System.in);
    public static void createMessage() {
        System.out.println("Escribe tu mensaje: ");
        String message = scanner.nextLine();
        System.out.println("Tu nombre: ");
        String name = scanner.nextLine();

        Message messageObject = new Message();
        messageObject.setMessage(message);
        messageObject.setAuthor(name);

        MessageDAO.createMessageDB(messageObject);
    }

    public static void messageList() {
        System.out.println("---------------------------------");
        System.out.println("MESSAGES");
        ArrayList<Message> messages = MessageDAO.readMessageDB();

        for (Message message:messages) {
            System.out.println("id: " + message.getId());
            System.out.println("Message: " + message.getMessage());
            System.out.println("Author: " + message.getAuthor());
            System.out.println("Date: " + message.getDate());
            System.out.println("");
        }
    }

    public static void deleteMessage() {
        System.out.println("Escribe el id del mensaje a borrar: ");
        int id = scanner.nextInt();
        MessageDAO.deleteMessageDB(id);
    }

    public static void updateMessage() {
        System.out.println("Escribe el id del mensaje a editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Escribe tu nuevo mensaje: ");
        String message = scanner.nextLine();
        System.out.println("Tu nombre: ");
        String name = scanner.nextLine();

        Message messageObject = new Message();
        messageObject.setId(id);
        messageObject.setMessage(message);
        messageObject.setAuthor(name);

        MessageDAO.updateMessageDB(messageObject);
    }
}

package com.persistence.controller;

import java.util.Scanner;
import static com.persistence.manager.MessageService.*;

public class MessagesController {
    Scanner scanner = new Scanner(System.in);

    public void processMessages() {
        int selection = 0;

        do{
            System.out.println("--------------------------");
            System.out.println("Welcome to the message app");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            selection = scanner.nextInt();

            switch (selection) {
                case 1 -> createMessage();
                case 2 -> messageList();
                case 3 -> updateMessage();
                case 4 -> deleteMessage();
                case 5 -> System.out.println("Gracias por usar nuestro servicio");
                default -> System.out.println("Opción no válida");
            }
        }
        while (selection != 5) ;
    }
}
package com.persistence;

import com.persistence.controller.MessagesController;

public class Main {
    public static void main(String[] args) {
        MessagesController messagesController = new MessagesController();
        messagesController.processMessages();
    }
}
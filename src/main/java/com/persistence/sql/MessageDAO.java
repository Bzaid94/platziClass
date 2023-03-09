package com.persistence.sql;

import com.persistence.bean.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {

    public static void createMessageDB(Message message){
        ConnectionDB connectionDB = new ConnectionDB();

        try {
        Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = null;
        try{
            String query = "INSERT INTO message (message, author) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, message.getMessage());
            preparedStatement.setString(2, message.getAuthor());
            preparedStatement.executeUpdate();
            System.out.println("Message created");
        }catch (SQLException e){
            System.out.println(e.getClass().getSimpleName() + "_" + e.getMessage());
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<Message> readMessageDB(){
        ConnectionDB connectionDB = new ConnectionDB();
        ArrayList<Message> messages = new ArrayList<Message>();

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultset = null;
                String query = "SELECT * FROM message";
                preparedStatement = connection.prepareStatement(query);
                resultset = preparedStatement.executeQuery();

            while (resultset.next()){
                Message message = new Message();
                message.setId(resultset.getInt("id"));
                message.setMessage(resultset.getString("message"));
                message.setAuthor(resultset.getString("author"));
                message.setDate(String.valueOf(resultset.getDate("date")));
                messages.add(message);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return messages;
    }

    public static void deleteMessageDB(int id){
        ConnectionDB connectionDB = new ConnectionDB();

        try {
            Connection connection = connectionDB.getConnection();

            try{
                String query = "DELETE FROM message WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                int countRows = preparedStatement.executeUpdate();
                if(countRows > 0){
                    System.out.println("Message deleted");
                }else {
                    System.out.println("Message not found");
                }

            }catch (SQLException e){
                System.out.println(e.getClass().getSimpleName() + "_" + e.getMessage());
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateMessageDB(Message message){
        ConnectionDB connectionDB = new ConnectionDB();

        try {
            Connection connection = connectionDB.getConnection();

            try{
                String query = "UPDATE message SET message = ?, author = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessage());
                preparedStatement.setString(2, message.getAuthor());
                preparedStatement.setInt(3, message.getId());
                int countRows = preparedStatement.executeUpdate();

                if(countRows > 0){
                    System.out.println("Message updated");
                }else {
                    System.out.println("Message not found");
                }

            }catch (SQLException e){
                System.out.println(e.getClass().getSimpleName() + "_" + e.getMessage());
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
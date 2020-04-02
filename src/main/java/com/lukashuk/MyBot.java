package com.lukashuk;


import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class MyBot extends TelegramLongPollingBot {

    public static String USERNAME = "myStupidBot_bot";
    public static String TOKEN = "724951237:AAHZcpLkQ2FRj-fr29OdXgHltnQM1ZRWlsY";


    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage());
        Message msg = update.getMessage();
        sendMsg(msg, msg.getText());
        if (msg.getChatId() == 809108873) {
            sendMsg(msg, "Vladislav kotik");
        }
    }


    @SuppressWarnings("deprecation")
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        try {
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}

package uz.reverse;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ReverseBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "echchooobot";
    }

    @Override
    public String getBotToken() {
        return "5048492042:AAGjad1QhLU2HyM0Vft3QRE4ct6nVLkjzvQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            String str = messageText;
            String[] words = str.split(" ");
            StringBuilder reverseWord = null;
            for (String word : words) {

                String rWord = word;
                reverseWord = new StringBuilder(rWord);
                reverseWord.reverse();
                System.out.println(reverseWord);
            }


            SendMessage message = new SendMessage();

            message.setChatId(String.valueOf(chatId));
            message.setText(String.valueOf(reverseWord));

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}

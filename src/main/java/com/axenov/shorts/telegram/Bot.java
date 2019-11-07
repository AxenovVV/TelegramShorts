package com.axenov.shorts.telegram;

import com.axenov.shorts.service.LinkShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private final LinkShortener linkShortener;

    @Autowired
    public Bot(LinkShortener linkShortener) {
        this.linkShortener = linkShortener;
    }

    public void onUpdateReceived(Update update) {
        sendResponse(
                update.getMessage().getChatId(),
                linkShortener.shortAndSaveOriginalLink(update.getMessage().getText()));
    }

    public String getBotUsername() {
        return System.getenv("TELEGRAM_NAME");
    }

    public String getBotToken() {
        return System.getenv("TELEGRAM_TOKEN");
    }

    private void sendResponse(long chatId, String shortLink) {
        try {
            execute(new SendMessage()
                    .setChatId(chatId)
                    .setText(shortLink));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

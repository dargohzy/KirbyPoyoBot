import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class KirbyPoyoBot extends TelegramLongPollingBot {

    ArrayList<String> responses = new ArrayList<String>();

    public KirbyPoyoBot() {
        responses.add("Poyo poyo! <(^.^)>");
        responses.add("Poyoooooo!! ༼ つ ◕_◕ ༽つ");
        responses.add("Poyo... (●´ω｀●)");
    }

    public void onUpdateReceived(Update update) {

        String poyo = update.getMessage().getText();

        SendMessage message = new SendMessage();
        message.setText(getRandomPoyo());
        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "KirbyPoyoBot";
    }

    public String getBotToken() {
        return "1138420396:AAEctFB1TDFvHxqzxkT-vQbczbkPj2a2nIw";
    }

    private String getRandomPoyo() {
        int rng = (int) (Math.random() * (this.responses.size()));

        return responses.get(rng);
    }
}

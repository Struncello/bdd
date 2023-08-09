package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashBoardPage {
    private final String balanceStringStart = "баланс: ";
    private final String balanceStringFinish = " р.";
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private final ElementsCollection cards = $$(".list__item div");

    public DashBoardPage() {
        heading.shouldBe(visible);
    }

    public int getCardBalance(DataHelper.CardInfo cardInfo) {
        String text;
        text = cards.findBy(text(cardInfo.getCardNumber().substring(15))).getText();
        return extractBalance(text);
    }

    public int getCardBalance(int index) {
        var text = cards.get(index).getText();
        return extractBalance(text);
    }

    public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
        cards.findBy(attribute("data-test-id", cardInfo.getTestId())).$("button").click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStringStart);
        var finish = text.indexOf(balanceStringFinish);
        var value = text.substring(start + balanceStringStart.length(), finish);
        return Integer.parseInt(value);
    }
}
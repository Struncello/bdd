package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorPopup = $(".notification__content");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashBoardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(String.valueOf(verificationCode));
        verifyButton.click();
        return new DashBoardPage();
    }

    public void verifyCodeIsInvalid() {
        errorPopup.shouldHave(text("Неверно указан код! Попробуйте ещё раз."));
    }
}
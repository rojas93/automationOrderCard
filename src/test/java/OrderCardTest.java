import org.junit.jupiter.api.Test;
import page.ActionOrderCard;

import static com.codeborne.selenide.Condition.exactText;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderCardTest {


    @Test
    public void testValidName(){
        ActionOrderCard actionOrderCard = new ActionOrderCard();
        actionOrderCard.openOrderCard();
        actionOrderCard.setName("");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName.shouldHave(exactText("Поле обязательно для заполнения"));

        actionOrderCard.setName("123");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        actionOrderCard.setName("!@#$%^&*()");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        actionOrderCard.setName("dasdasdsad");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        actionOrderCard.setName("Тест-тес");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Укажите точно как в паспорте"));

        actionOrderCard.setName("Тест тес");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Укажите точно как в паспорте"));


        actionOrderCard.setName("Тест тес-тем");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorName
                .shouldHave(exactText("Укажите точно как в паспорте"));
    }

    @Test
    public void testValidPhone(){
        ActionOrderCard actionOrderCard = new ActionOrderCard();
        actionOrderCard.openOrderCard();
        actionOrderCard.setName("Тест");
        actionOrderCard.setPhone("");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorPhone.shouldHave(exactText("Поле обязательно для заполнения"));

        actionOrderCard.setPhone("фывфывф");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorPhone.shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, " +
                "+79012345678."));

        actionOrderCard.setPhone("12345678901");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorPhone.shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, " +
                "+79012345678."));

        actionOrderCard.setPhone("!@#$%^&*()");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorPhone.shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, " +
                "+79012345678."));

        actionOrderCard.setPhone("+12345678901");
        actionOrderCard.clickButtonSubmit();
        actionOrderCard.messageErrorPhone.shouldHave(exactText("На указанный номер моб. тел. будет отправлен смс-код " +
                "для подтверждения заявки на карту. Проверьте, что номер ваш и введен корректно."));
    }

    @Test
    public void testSendOrder(){
        ActionOrderCard actionOrderCard = new ActionOrderCard();
        actionOrderCard.openOrderCard();
        actionOrderCard.setName("Тест");
        actionOrderCard.setPhone("+12345678901");
        actionOrderCard.clickButtonSubmit();
        assertFalse(actionOrderCard.orderSuccess.exists());

        actionOrderCard.clickAgreement();
        actionOrderCard.clickButtonSubmit();
        assertTrue(actionOrderCard.orderSuccess.exists());
        actionOrderCard.orderSuccess.shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

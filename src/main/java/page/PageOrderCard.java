package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageOrderCard {

    public static String inputNameXpath = "//input[@name='name']";
    public SelenideElement inputName = $(By.xpath(inputNameXpath));

    public static String inputPhoneXpath = "//input[@name='phone']";
    public SelenideElement inputPhone = $(By.xpath(inputPhoneXpath));

    public static String inputAgreementXpath = "//*[@data-test-id='agreement']/span";
    public SelenideElement inputAgreement = $(By.xpath(inputAgreementXpath));

    public static String buttonSubmitXpath = "//button";
    public SelenideElement buttonSubmit = $(By.xpath(buttonSubmitXpath));

    public static String messageErrorNameXpath = "//*[@data-test-id='name']//*[@class='input__sub']";
    public SelenideElement messageErrorName = $(By.xpath(messageErrorNameXpath));

    public static String messageErrorPhoneXpath = "//*[@data-test-id='phone']//*[@class='input__sub']";
    public SelenideElement messageErrorPhone = $(By.xpath(messageErrorPhoneXpath));

    public static String orderSuccessXpath = "//*[@data-test-id='order-success']";
    public SelenideElement orderSuccess = $(By.xpath(orderSuccessXpath));
}

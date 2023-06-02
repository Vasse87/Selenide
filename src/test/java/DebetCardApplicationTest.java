import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebetCardApplicationTest {

    @Test
    void shouldReturnPositiveResult() {
        open("http://localhost:9999");
        //Thread.sleep(10000000);
        SelenideElement form = $("[id = root]");
        form.$("[data-test-id = name] input").setValue("Васильев Сергей");
        form.$("[data-test-id = phone] input").setValue("+79967923485");
        form.$("[data-test-id = agreement]").click();
        form.$("button").click();
        $("[data-test-id = order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldReturnPositiveResultWithHyphen()  {
        open("http://localhost:9999");
        //Thread.sleep(10000000);
        SelenideElement form = $("[id = root]");
        form.$("[data-test-id = name] input").setValue("Васильева-Татарирова Анна-Луиза");
        form.$("[data-test-id = phone] input").setValue("+79967923485");
        form.$("[data-test-id = agreement]").click();
        form.$("button").click();
        $("[data-test-id = order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

package guru.qa;

 import com.codeborne.selenide.Configuration;
 import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void setConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

}

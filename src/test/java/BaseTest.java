import Helper.FileReader;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

class BaseTest {

    private static final String URL_KEY = "URL";

    private String url;

    BaseTest () throws IOException {
        url = FileReader.getValue(URL_KEY);
    }

    void openHomePage() {
        open(url);
    }

    void quit(){
        quit();
    }
}

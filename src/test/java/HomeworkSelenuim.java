import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class HomeworkSelenuim {
    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void exampleTest() throws InterruptedException {

        driver.get("https://www.rgs.ru/");
        String menuXpath = "//li[contains(@class, 'dropdown adv-analytics-navigation-line1-link current')]";    // заходим в меню на сайте
        driver.findElement(By.xpath(menuXpath)).click();


        String dmcXpath = "//a[contains(text(), 'ДМС')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dmcXpath)));        // заходим в ДМС на сайте
        driver.findElement(By.xpath(dmcXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));        // проверяем заголовок в ДМС
        Assert.assertEquals("Содержимое ссылки не соответствует ожиданию",
                "ДМС — добровольное медицинское страхование",
                driver.findElement(By.xpath("//h1")).getText());

        String clickButtonRequest = "//a[contains(text(),'Отправить заявку')]";             // Заходим в форму "Отправить заявку"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickButtonRequest)));
        driver.findElement(By.xpath("//a[contains(text(),'Отправить заявку')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Заявка на добровольное медицинское страхование')]")));
        Assert.assertEquals("Содержимое ссылки не соответствует ожиданию",
                "Заявка на добровольное медицинское страхование",
                driver.findElement(By.xpath("//b[contains(text(),'Заявка на добровольное медицинское страхование')]")).getText());  // проверяем текст  в заявке


        String lastNameXpath = "//input[@name = 'LastName']";                                 // ввод фамилии в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lastNameXpath)));
        WebElement elementLastName = driver.findElement(By.xpath(lastNameXpath));
        elementLastName.click();
        elementLastName.sendKeys("Бондаренко");


        String firstNameXpath = "//input[@name = 'FirstName']";                             // ввод имени в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstNameXpath)));
        WebElement elementFirstName = driver.findElement(By.xpath(firstNameXpath));
        elementFirstName.click();
        elementFirstName.sendKeys("Артем");

        String middleNameXpath = "//input[@name = 'MiddleName']";                             // ввод отчества в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(middleNameXpath)));
        WebElement elementMiddleName = driver.findElement(By.xpath(middleNameXpath));
        elementMiddleName.click();
        elementMiddleName.sendKeys("Алексеевич");


        String regionXpath = "//select[@name = 'Region']";                                // выбор региона в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(regionXpath)));
        WebElement elementRegion = driver.findElement(By.xpath(regionXpath));
        elementRegion.click();
        elementRegion.findElement(By.xpath("//option[contains(text(), 'Москва')]")).click();


        String phoneNumberXpath = "//input[contains(@data-bind, 'value: Phone')]";      // ввод телефона в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(phoneNumberXpath)));
        WebElement elementPhone = driver.findElement(By.xpath(phoneNumberXpath));
        elementPhone.click();
        elementPhone.sendKeys("8_888_888_888");


        String emailXpath = "//input[@name = 'Email']";                               // ввод почты в заявке
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        WebElement elementEmail = driver.findElement(By.xpath(emailXpath));
        elementEmail.click();
        elementEmail.sendKeys("qwertyqwerty");


        String dateContactXpath = "//input[@name = 'ContactDate']";                         // выбор даты контакта
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateContactXpath)));
        WebElement elementDateContact = driver.findElement(By.xpath(dateContactXpath));
        elementDateContact.click();
        elementDateContact.findElement(By.xpath("//td[@data-datepicker-timestamp='1590710400000']")).click();


        String commentXpath = "//textarea[@name = 'Comment']";                          // ввод комментария
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(commentXpath)));
        WebElement elementComment = driver.findElement(By.xpath(commentXpath));
        elementComment.click();
        elementComment.sendKeys("Я согласен на обработку");


        String checkBoxXpath = "//input[@class = 'checkbox']";                          // ставим галку в чекбокс
        WebElement elementCheckBox = driver.findElement(By.xpath(checkBoxXpath));
        elementCheckBox.click();


        Assert.assertEquals("Поле 'Фамилия' не соответствует ожиданию",         // проверяем заполненое поле "Фамилия"
                "Бондаренко", driver.findElement(By.name("LastName")).getAttribute("value"));


        Assert.assertEquals("Поле 'Имя' не соответствует ожиданию",         // проверяем заполненое поле "Имя"
                "Артем", driver.findElement(By.name("FirstName")).getAttribute("value"));


        Assert.assertEquals("Поле 'Отчество' не соответствует ожиданию",        // проверяем заполненое поле "Отчество"
                "Алексеевич", driver.findElement(By.name("MiddleName")).getAttribute("value"));

        Assert.assertEquals("Поле'Регион' не соответствует ожиданию",   // проверяем заполненое поле "Регион"
                "77", driver.findElement(By.name("Region")).getAttribute("value"));

        Assert.assertEquals("Поле'Эл.почта' не соответствует ожиданию",  // проверяем заполненое поле "Эл.почта"
                "qwertyqwerty", driver.findElement(By.name("Email")).getAttribute("value"));

        Assert.assertEquals("Поле'Телефон' не соответствует ожиданию",  // проверяем заполненое поле "Телефон"
                "+7 (888) 888-88-88", driver.findElement(By.xpath(phoneNumberXpath)).getAttribute("value"));

        Assert.assertEquals("Поле'Комментарии' не соответствует ожиданию", // проверяем заполненое поле "Комментарии"
                "Я согласен на обработку", driver.findElement(By.name("Comment")).getAttribute("value"));


        String buttonXpath = "//button[@id='button-m']"; // нажимаем кнопку "Отправить"
        driver.findElement(By.xpath(buttonXpath)).click();

        String wrongEmailXpath = "//span[contains(text(),'Введите адрес электронной почты')]";  // проверяем что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongEmailXpath)));
        Assert.assertEquals("Поле 'Эл.почта' содержит сообщение об ошибке",
                "Введите адрес электронной почты", driver.findElement(By.xpath(wrongEmailXpath)).getText());


    }


    @After
    public void endTest() {
        driver.quit();
    }

}

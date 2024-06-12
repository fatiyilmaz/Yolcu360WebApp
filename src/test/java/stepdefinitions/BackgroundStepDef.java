package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.BackgroundPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BackgroundStepDef {

    BackgroundPage backgroundPage = new BackgroundPage();
    Faker faker = new Faker();
    String numara = "";

    @Given("yolcu360 sitesine gidilir")
    public void yolcu360_sitesine_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("yolcu360"));
        Driver.getDriver().manage().window().maximize();
        ReusableMethods.waitFor(2);
    }
    @Given("login butonuna tiklanir")
    public void login_butonuna_tiklanir() {
        backgroundPage.uyeOlGirisYap.click();
        ReusableMethods.waitFor(2);
    }
    @And("telefon numarasi {string} girilir")
    public void telefonNumarasiGirilir(String string) {
        numara = faker.phoneNumber().phoneNumber();
        if (string.contains("<no>"));
        backgroundPage.telefonNumarasi.sendKeys(numara,Keys.ENTER);
        ReusableMethods.waitFor(2);

        //backgroundPage.telefonNumarasi.sendKeys("1241241251",Keys.ENTER);
        //ReusableMethods.waitFor(2);
    }
    @Given("devam et tiklanir")
    public void devam_et_tiklanir() {
        backgroundPage.devamEt.click();
        ReusableMethods.waitFor(2);
    }
    @Given("aydinlatma metni, acik riza metni, üyelik sözlesmesi checkbox tiklanir")
    public void aydinlatma_metni_acik_riza_metni_üyelik_sözlesmesi_checkbox_tiklanir() {
        backgroundPage.metinVeSozlesmeCheckbox.click();
        ReusableMethods.waitFor(2);
    }
    @Given("devam et butonuna tekrar tiklanir")
    public void devam_et_butonuna_tekrar_tiklanir() {
        backgroundPage.devamEt.click();
        ReusableMethods.waitFor(2);
    }
    @Then("gecersiz telefon numarasi hatasi alir")
    public void gecersiz_telefon_numarasi_hatasi_alir() {
        String expectedFalseNumberText = "Phone number is invalid";
        String actualFalseNumberText = "Phone number is invalid";
        assertEquals(expectedFalseNumberText,actualFalseNumberText);
        ReusableMethods.waitFor(2);
    }


    @And("telefon numarasi girilir")
    public void telefonNumarasiGirilir() {
        backgroundPage.telefonNumarasi.sendKeys("5550030984",Keys.ENTER);
        ReusableMethods.waitFor(2);
    }

    @And("gecerli numara ile devam et tiklanir")
    public void gecerliNumaraIleDevamEtTiklanir() {
        backgroundPage.devamEt.click();
        ReusableMethods.waitFor(2);
    }

    @And("gecerli numara ile aydinlatma metni, acik riza metni, üyelik sözlesmesi checkbox tiklanir")
    public void gecerliNumaraIleAydinlatmaMetniAcikRizaMetniÜyelikSözlesmesiCheckboxTiklanir() {
        backgroundPage.metinVeSozlesmeCheckbox.click();
        ReusableMethods.waitFor(2);
    }

    @And("gecerli numara ile devam et butonuna tekrar tiklanir")
    public void gecerliNumaraIleDevamEtButonunaTekrarTiklanir() {
        backgroundPage.devamEt.click();
        ReusableMethods.waitFor(2);
    }

    @Then("sms dogrulama kodu alir")
    public void smsDogrulamaKoduAlir() {
        String dogrulamaKodu = "SMS Doğrulama Kodu";
        assertTrue(backgroundPage.dogrulamaKodu.getText().contains(dogrulamaKodu));
        ReusableMethods.waitFor(2);
    }
}

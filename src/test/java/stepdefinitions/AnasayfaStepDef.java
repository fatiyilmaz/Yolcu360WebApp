package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AnasayfaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.KeyStoreException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotEquals;

public class AnasayfaStepDef {

    AnasayfaPage anasayfaPage = new AnasayfaPage();
    String expectedUrl = "";
    Faker faker = new Faker();
    String aracBolgesi = "";

    //dil
    @Given("ulke simgesine tiklanir")
    public void ulke_simgesine_tiklanir() {
        expectedUrl = Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(1);

       anasayfaPage.dil.click();
       ReusableMethods.waitFor(2);
    }
    @Given("farkli ulkeler gorur")
    public void farkli_ulkeler_gorur() {
        int count = 1;
        for (int i = 0; i < anasayfaPage.tumDiller.size(); i++) {
            System.out.println(count + " " + anasayfaPage.tumDiller.get(i).getText());
            count++;
        }
        ReusableMethods.waitFor(2);
    }
    @Given("farkli bir ulke dili secer")
    public void farkli_bir_ulke_secer() {
        anasayfaPage.dilDegisikligi.click();
        ReusableMethods.waitFor(2);
    }
    @Then("dil degisikligi dogrulanir")
    public void dil_degisikligi_dogrulanir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertNotEquals(expectedUrl,actualUrl);//Esit degil
        ReusableMethods.waitFor(2);
    }


    //arac
    @And("arac alınacak yer {string} yazilir")
    public void aracAlınacakYerYazilir(String string) {
        aracBolgesi = faker.address().cityName();
        if (string.contains("<aracyeri>"));
        anasayfaPage.aracYeri.sendKeys(aracBolgesi,Keys.ENTER);
        ReusableMethods.waitFor(2);
    }

    @And("alis tarihi girilir")
    public void alisTarihiGirilir() {
        anasayfaPage.alisTarihi.click();
        ReusableMethods.waitFor(1);
        Select dropdown = new Select(anasayfaPage.alisTarihiSaat);
        dropdown.selectByValue("22");
        anasayfaPage.alisTarihi.click();
        ReusableMethods.waitFor(2);
    }

    @And("alis saati girilir")
    public void alisSaatiGirilir(String arg0) {

    }

    @And("birakis tarihi girilir")
    public void birakisTarihiGirilir(String arg0) {

    }

    @And("birakis saati girilir")
    public void birakisSaatiGirilir(String arg0) {

    }

    @And("arac ara butonuna tiklanir")
    public void aracAraButonunaTiklanir() {

    }

    @Then("arac listesi dogrulanir")
    public void aracListesiDogrulanir() {
    }


    //tumtedarikciler
    @And("tum tedarikciler butonu tiklanir")
    public void tumTedarikcilerButonuTiklanir() {
        anasayfaPage.tumTedarikcilerButton.click();
        ReusableMethods.waitFor(2);
    }

    @And("tum tedarikciler sayfasina gecis dogrulanir")
    public void tumTedarikcilerSayfasinaGecisDogrulanir() {
        System.out.println(anasayfaPage.tumTedarikcilerText.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("alfabeye gore sirketler gorulur ve dogrulanir")
    public void alfabeyeGoreSirketlerGorulurVeDogrulanir() {
        int count = 1;
        for (int i = 0; i < anasayfaPage.alfabeSirketler.size(); i++) {
            System.out.println(count + " " + anasayfaPage.alfabeSirketler.get(i).getText());
            count++;
            ReusableMethods.waitFor(2);
        }
        for (int i = 1; i < anasayfaPage.alfabeSirketler.size(); i++) {
            anasayfaPage.alfabeSirketler.get(i).click();
            ReusableMethods.waitFor(2);
            System.out.println(Driver.getDriver().getCurrentUrl().contains("i"));
            ReusableMethods.scrollHome();
        }
    }


    //footer
    @And("arac kiralama gorur")
    public void aracKiralamaGorur() {
        ReusableMethods.scrollEnd();
        System.out.println(anasayfaPage.aracKiralamaText.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @And("arac kiralama alt kisimlarina tiklar ve gecis dogrulanir")
    public void aracKiralamaAltKisimlarinaTiklarVeGecisDogrulanir() {
        String window1Handle = Driver.getDriver().getWindowHandle();
        for (int i = 1; i < anasayfaPage.aracKiralamaFooter.size(); i++) {
            anasayfaPage.aracKiralamaFooter.get(i).click();
            ReusableMethods.waitFor(3);
            String actualUrl = Driver.getDriver().getCurrentUrl();
            assertNotEquals(expectedUrl,actualUrl);
            ReusableMethods.waitFor(3);
            Driver.getDriver().navigate().back();
            ReusableMethods.scrollEnd();
            ReusableMethods.waitFor(3);
            Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
            System.out.println(allWindowHandles);
            for (String eachHandle : allWindowHandles) {
                if (!eachHandle.equals(window1Handle)) {
                    Driver.getDriver().switchTo().window(eachHandle);
                    String window2handleUrl = Driver.getDriver().getCurrentUrl();
                    assertNotEquals(expectedUrl, window2handleUrl);
                    ReusableMethods.waitFor(2);
                    try {
                    Driver.getDriver().switchTo().window(window1Handle);
                    if (window1Handle.equals(expectedUrl));
                    }catch (Exception e){

                    }
                }
            }
        }
    }

    @And("populer lokasyonlar gorur")
    public void populerLokasyonlarGorur() {
        ReusableMethods.scrollEnd();
        ReusableMethods.waitFor(2);
        System.out.println(anasayfaPage.populerLokasyonlarText.isDisplayed());
        ReusableMethods.waitFor(2);
    }


    @And("populer lokasyonlar alt kisimlarina tiklar ve gecis dogrulanir")
    public void populerLokasyonlarAltKisimlarinaTiklarVeGecisDogrulanir() {
        for (int i = 1; i < anasayfaPage.populerLokasyonlarFooter.size(); i++) {
            anasayfaPage.aracKiralamaFooter.get(i).click();
            ReusableMethods.waitFor(2);
            String actualUrl = Driver.getDriver().getCurrentUrl();
            assertNotEquals(expectedUrl, actualUrl);
            ReusableMethods.waitFor(2);
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            ReusableMethods.scrollEnd();
        }
    }

    @And("populer arac kiralama sirketleri gorur")
    public void populerAracKiralamaSirketleriGorur() {
    }

    @And("populer arac kiralama sirketleri alt kisimlarina tiklar ve gecis dogrulanir")
    public void populerAracKiralamaSirketleriAltKisimlarinaTiklarVeGecisDogrulanir() {
    }

    @And("ucak bileti gorur")
    public void ucakBiletiGorur() {
    }

    @And("ucak bileti alt kisimlarina tiklar ve gecis dogrulanir")
    public void ucakBiletiAltKisimlarinaTiklarVeGecisDogrulanir() {
    }

    @And("kurumsal & destek gorur")
    public void kurumsalDestekGorur() {
    }

    @And("kurumsal & destek alt kisimlarina tiklar ve gecis dogrulanir")
    public void kurumsalDestekAltKisimlarinaTiklarVeGecisDogrulanir() {
    }

    @And("mobil uygulamamız gorur")
    public void mobilUygulamamızGorur() {
    }

    @And("mobil uygulama alt kisimlarina tiklar ve gecis dogrulanir")
    public void mobilUygulamaAltKisimlarinaTiklarVeGecisDogrulanir() {
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BackgroundPage {
    public BackgroundPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='header-login header-links-item mobile:hidden tablet:hidden']")
    public WebElement uyeOlGirisYap;
    @FindBy(xpath = "//div[@class='pt-1 w-[312px]']//input[@id='phone-input']")
    public WebElement telefonNumarasi;
    @FindBy(xpath = "//button[@cms-key='login_button_text']")
    public WebElement devamEt;
    @FindBy(xpath = "//div[@class='pt-11 px-3 desktop:px-12']//label[@class='flex w-full select-none flex-row items-center justify-start cursor-pointer gap-[6px] !w-max']")
    public WebElement metinVeSozlesmeCheckbox;
    @FindBy(xpath = "//div[@class='modal']//h2")
    public WebElement dogrulamaKodu;


}

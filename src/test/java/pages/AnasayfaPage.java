package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AnasayfaPage {
    public AnasayfaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //dil
    @FindBy(xpath = "//div[@id='dropdown-lang']")
    public WebElement dil;
    @FindBy(xpath = "//div[@class='grid dropdown-content grid-cols-2']//span[@class='list-item__lang']")
    public List<WebElement> tumDiller;
    @FindBy(xpath = "(//div[@class='grid dropdown-content grid-cols-2']//span[@class='list-item__lang'])[7]")
    public WebElement dilDegisikligi;

    //arac
    @FindBy(xpath = "//input[@id='inputPickUpLocation']")
    public WebElement aracYeri;
    @FindBy(xpath = "(//div[@class='dp__main dp__theme_light']//span[@class='flex flex-row gap-x-1 items-center w-max']//i)[1]")
    public WebElement alisTarihi;
    @FindBy(xpath = "(//div[@class='dp__calendar_row'])[4]")
    public WebElement alisTarihiSaat;

    //tumtedarikciler
    @FindBy(xpath = "//a[contains(text(),'Tüm Tedarikçiler')]")
    public WebElement tumTedarikcilerButton;
    @FindBy(xpath = "//h2[@class='text-xl font-bold']")
    public WebElement tumTedarikcilerText;
    @FindBy(xpath = "//div[@class='flex items-center justify-center gap-1 flex-wrap relative -top-[39px] bg-white w-full rounded-[10px] px-6 py-3']//a")
    public List<WebElement> alfabeSirketler;

    //footer
    @FindBy(xpath = "//div[@id='text_rent_car']")
    public WebElement aracKiralamaText;
    @FindBy(xpath = "//div[@class='flex-1 tablet:text-center'][1]//a")
    public List<WebElement> aracKiralamaFooter;
    @FindBy(xpath = "//div[@id='text_popular_locations']")
    public WebElement populerLokasyonlarText;
    @FindBy(xpath = "//div[@class='flex-1 tablet:text-center'][2]//a")
    public List<WebElement> populerLokasyonlarFooter;
    @FindBy(xpath = "//div[@id='text_popular_rent_car']")
    public WebElement populerAracKiralamaSirketleriText;
    @FindBy(xpath = "//div[@class='flex-1 tablet:text-center'][3]//a")
    public List<WebElement> populerAracKiralamaSirketleriFooter;


}

package pages.Occupation_Management;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DataGenerator;

public class Occupation_SetupPage extends BasePage {

    private By Occupation_management = By.xpath("//p[text()='Occupation Management']");
    private By Occupation_setup = By.xpath("//p[text()='Occupation Setup']");
    private By add_occupation = By.xpath("//div[text()='Add Occupation']");
    private By update_occupation = By.xpath("//button[contains(@title,'Edit')]");
    private By edit_occupation = By.xpath("(//button[contains(@title,'Edit')])[1]");
    private By select_occupationGroup = By.xpath("//input[@aria-label='occupationGroupId']");
    private By occupation_name = By.name("occupationName");
    private By save_Occupation = By.xpath("//div[text()='Save']");
    private By LoadData = By.xpath("//div[text()='Load Data']");
    private By delete_occupationsetup = By.xpath("(//button[@title='Delete'])[1]");
    private By delete_button = By.xpath("//button[contains(@title,'Delete')]");

    public Occupation_SetupPage(WebDriver driver){
        super(driver);
    }

    public void Go_to_OccupationSetUp_Page(){

        click(Occupation_management);
        click(Occupation_setup);
    }

    public void Click_on_Edit(){
        click(edit_occupation);
    }

    public void Clear_OccupationName(){
        driver.findElement(By.name("occupationName")).clear();
    }

    public void Click_on_addOccupation(){
        click(add_occupation);
    }

    public void Select_OccupationGroup(){
        selectFromDropdown(select_occupationGroup,"Healthcare");
    }

    public void Enter_OccupationName(String Occupationname) throws InterruptedException {
        Thread.sleep(3000);
        typeText(occupation_name,Occupationname);
    }

    public void Save_OccupationSetup(){
        click(save_Occupation);
    }

    public void update_occupation(){
        click(update_occupation);
    }

    public void Click_on_LoadData(){
        click(LoadData);
    }

    public void Delete_Occupation_Setup(){
        click(delete_occupationsetup);
    }
    public void delete_button(){
        click(delete_button);
    }


}

package pages.Occupation_Management;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Occupation_GroupSetup extends BasePage {

    public Occupation_GroupSetup(WebDriver driver){
        super(driver);
    }

     By Occupation_management = By.xpath("//p[text()='Occupation Management']");
    By Occupation_GroupSetUp = By.xpath("//p[text()='Occupation Group Setup']");
    By Add_OccupationGroup = By.xpath("//button[contains(@title,'Add Occupation Group')]");
    By Occupation_Group_Name = By.name("occupationGroupName");
    By Local_Group_Name = By.name("occupationGroupNameLocLang");
    By Save_button = By.xpath("//button[contains (@title,'Save')]");
    By Load_Data = By.xpath("//button[contains(@title,'Load Data')]");
    By Edit_GroupName = By.xpath("(//button[contains(@title , 'Edit')])[1]");
    By Update = By.xpath("//button[contains(@title,'Update')]");
    By Delete = By.xpath("(//button[contains(@title , 'Delete')])[1]");
    By Delete_button   = By.xpath("//button[.='Delete']");


    public void Click_on_OccupationGroupSetup(){
        click(Occupation_management);
        click(Occupation_GroupSetUp);
    }

    public void Click_on_AddOccupationSetup(){
        click(Add_OccupationGroup);
    }

    public void Enter_GroupName(String groupName){
        typeText(Occupation_Group_Name ,groupName );
    }

    public void Enter_Local_GroupName(String localName){
        typeText(Local_Group_Name,localName);
    }

    public void Click_on_Save(){
        click(Save_button);
    }

    public void Click_on_LoadData(){
        click(Load_Data);
    }

    public void Click_on_Edit(){
        click(Edit_GroupName);
    }

    public void Click_on_Update(){
        click(Update);
    }

    public void Click_On_Delete(){
        click(Delete);
    }

    public void Click_on_Delete_Button(){
        click(Delete_button);
    }
}

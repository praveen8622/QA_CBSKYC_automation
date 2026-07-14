package tests.Occupation_Management;

import base.BaseTestSequential;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Occupation_Management.Occupation_SetupPage;
import utilities.DataGenerator;

public class Occupation_Setup extends BaseTestSequential {

    Occupation_SetupPage occupation;
    String random_occupations = DataGenerator.generateRandomOccupation();
    String random_editOccupations = DataGenerator.generateRandomOccupation();

    @BeforeClass
    public void pagesetup() {
        occupation = new Occupation_SetupPage(driver);
    }

    @Test(priority = 1, description = "Verify Save Occupation Setup")
    public void save_Occupation_Setup() throws InterruptedException {
        occupation.Go_to_OccupationSetUp_Page();
        occupation.Click_on_addOccupation();
        occupation.Select_OccupationGroup();
        occupation.Enter_OccupationName(random_occupations);
        occupation.Save_OccupationSetup();
        occupation.Click_on_LoadData();
    }

    @Test(priority = 2, description = "Verify Edit Occupation Setup")
    public void edit_Occupation_Setup() throws InterruptedException {
        occupation.Click_on_Edit();
        occupation.Select_OccupationGroup();
        occupation.Clear_OccupationName();
        occupation.Enter_OccupationName(random_editOccupations);
        occupation.update_occupation();
    }

    @Test(priority = 3, description = "Verify Delete Occupation Setup")
    public void delete_occupation_setup() {
        occupation.Delete_Occupation_Setup();
        occupation.delete_button();

    }

}

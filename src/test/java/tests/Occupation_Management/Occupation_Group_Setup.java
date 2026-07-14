package tests.Occupation_Management;

import base.BaseTestSequential;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Occupation_Management.Occupation_GroupSetup;
import utilities.DataGenerator;

public class Occupation_Group_Setup extends BaseTestSequential {

    Occupation_GroupSetup groupSetup ;
    String groupname = DataGenerator.generateRandomOccupation();
    String local_group_name = DataGenerator.generateRandomOccupation();
    String update_groupname = DataGenerator.generateRandomOccupation();
    String update_localname = DataGenerator.generateRandomOccupation();

    @BeforeClass
    public void pageSetup(){
        groupSetup = new Occupation_GroupSetup(driver);
    }

    @Test(priority = 1, description = "Verify the Add Occupation Group Setup")
    public void Add_Occupation_Group_SetUp(){
        groupSetup.Click_on_OccupationGroupSetup();
        groupSetup.Click_on_AddOccupationSetup();
        groupSetup.Enter_GroupName(groupname);
        groupSetup.Enter_Local_GroupName(local_group_name);
        groupSetup.Click_on_Save();
    }

    @Test(priority = 2 , description = "Verify Edit Occupation Group Setup")
    public void Edit_Occupation_Group_Setup(){
        groupSetup.Click_on_LoadData();
        groupSetup.Click_on_Edit();
        groupSetup.Enter_GroupName(update_groupname);
        groupSetup.Enter_Local_GroupName(update_localname);
        groupSetup.Click_on_Update();

    }

    @Test(priority = 3 , description = "Verify the Delete Occupation Group Name")
    public void Delete_Occupation_SetUp(){
        groupSetup.Click_On_Delete();
        groupSetup.Click_on_Delete_Button();
    }
}

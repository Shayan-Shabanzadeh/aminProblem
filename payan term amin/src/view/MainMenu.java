package view;

public class MainMenu extends Menu {
    public MainMenu() {
        super("Main menu", null);
        subMenus.put(1,new GetPatientInfo(this));
        subMenus.put(2,new makeNewAssign(this));
        subMenus.put(3,new makeAssignForPatient(this));
        subMenus.put(4,new PrintAssigns(this));

    }

}

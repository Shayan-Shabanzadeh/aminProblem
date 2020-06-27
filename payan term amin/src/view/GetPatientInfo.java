package view;

public class GetPatientInfo extends Menu {
    public GetPatientInfo( Menu parentMenu) {
        super("Get patient information", parentMenu);
    }

    @Override
    public void show() {
        System.out.println("Please Enter your information or write back to return.");
    }

    @Override
    public void execute()  {
        String input;
        Menu nextMenu=null;
        while (true) {
            try {
                input = getInput("^(\\d{10}\\s+\\w+\\s+\\w+\\s+\\d{11})|((?i)Back)$", "Please Enter you information or write back to return.");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(input.trim().equalsIgnoreCase("Back")){
            nextMenu=parentMenu;
        }else{
            String[] patientInfo=input.split("\\s");
            try {
                controller.makeNewPatient(patientInfo[0],patientInfo[1],patientInfo[2],patientInfo[3]);
                System.out.println("Your information has been added.");
                nextMenu=parentMenu;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        nextMenu.show();
        nextMenu.execute();
    }

}

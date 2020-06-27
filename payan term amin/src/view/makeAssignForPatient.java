package view;

import java.util.Date;

public class makeAssignForPatient extends Menu {

    public makeAssignForPatient(Menu parentMenu) {
        super("Assign a turn to the patient", parentMenu);
    }

    @Override
    public void show() {
        System.out.println("Please write your national code and a date you want to have assign or write back to return.");
    }

    @Override
    public void execute() {
        Menu nextMenu=this;
        String input;
        Date startDate;
        String date;
        while (true) {
            try {
                input = getInput("^\\d{10}$", "Please write your national code or write back to return");
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                date=getInput("^(^\\d{4}\\/\\d{1,2}\\/\\d{1,2}-\\d{1,2}:\\d{1,2}$)|((?i)Back)$","please enter a date");
                startDate=getDate(date);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        if(input.equalsIgnoreCase("Back")|| date.equalsIgnoreCase("Back")){
            nextMenu=parentMenu;
        }else{
            try {
                controller.setAssignForPatient(input,startDate);
                System.out.println("Done!");
                nextMenu=parentMenu;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        nextMenu.show();
        nextMenu.execute();


    }


}

package view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter.*;

public class makeNewAssign extends Menu {
    public makeNewAssign(Menu parentMenu) {
        super("Make new assign", parentMenu);
    }

    @Override
    public void show() {
        System.out.println("Please enter a date for assign or back to return");
    }

    @Override
    public void execute() {
        String input1;
        String input2;
        Date startDate;
        Date endDate;
        Menu nextMenu=this;
        while (true) {
            try {
                input1=getInput("^(^\\d{4}\\/\\d{1,2}\\/\\d{1,2}-\\d{1,2}:\\d{1,2}$)|((?i)Back)$", "Please enter a start date or write back to return.");
                input2=getInput("^(^\\d{4}\\/\\d{1,2}\\/\\d{1,2}-\\d{1,2}:\\d{1,2}$)|((?i)Back)$", "Please enter a end date or write back to return.");
                startDate=getDate(input1);
                endDate=getDate(input2);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if((input1.equalsIgnoreCase("Back")|| input2.equalsIgnoreCase("Back"))){
            nextMenu=parentMenu;
        }else{
        try {
            controller.makeNewAssign(startDate,endDate);
            nextMenu=parentMenu;
            System.out.println("done!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        nextMenu.show();
        nextMenu.execute();
    }





}

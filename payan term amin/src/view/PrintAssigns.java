package view;

import model.Assign;

import java.util.HashMap;

public class PrintAssigns extends Menu {
    public PrintAssigns(Menu parentMenu) {
        super("Print the assigned shifts", parentMenu);
    }

    @Override
    public void show() {
        super.show();
        try {
            HashMap<String, Assign> allUsedAssign=controller.showAllUsedAssign();
            for (String nationalCode : allUsedAssign.keySet()) {
                System.out.println(nationalCode+":"+allUsedAssign.get(nationalCode).getPatient().getFirstName()+""+allUsedAssign.get(nationalCode).getPatient().getLastName()+"--"+allUsedAssign.get(nationalCode).getStartDate());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void execute() {
        super.execute();
    }
}

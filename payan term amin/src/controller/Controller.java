package controller;

import model.Assign;
import model.DataBase;
import model.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Controller {
    private static Controller controller=new Controller();

    public static Controller getController() {
        return controller;
    }

    private Controller() {
    }

    private DataBase dataBase=DataBase.getDataBase();

    public void makeNewPatient(String nationalCode, String firstName, String lastName, String telephoneNumber) throws Exception {
        if(checkPatientWithNationalCode(nationalCode)==null) {
            Patient patient = new Patient(firstName, lastName, nationalCode, telephoneNumber);
            dataBase.getPatients().put(nationalCode, patient);
        }else{
            throw new Exception("There is patient with this national code.");
        }
    }
    public Patient checkPatientWithNationalCode(String nationalCode){
       return dataBase.getPatients().get(nationalCode);

    }

    public void makeNewAssign(Date startDate,Date endDate) throws Exception{
        if(checkAssign(startDate)==null){
            Assign assign=new Assign(startDate,endDate);
            dataBase.getAssigns().add(assign);
        }else{
            throw new Exception("This date has been used");
        }
    }
    public Assign checkAssign(Date startDate){
        for (Assign assign : dataBase.getAssigns()) {
           if(assign.getStartDate().equals(startDate))
               return assign;
        }
        return null;
    }

    public HashMap<String,Assign> showAllUsedAssign() throws Exception {
        ArrayList<Assign> allAssign=dataBase.getAssigns();
        HashMap<String,Assign> usedAssign=new HashMap<>();
        for (Assign assign : allAssign) {
            if(assign.getPatient()!=null){
                usedAssign.put(assign.getPatient().getNationalCode(),assign);
            }
        }
        if(!usedAssign.isEmpty()) {
            return usedAssign;
        }else{
            throw new Exception("There is no used assign yet");
        }
    }
    public void setAssignForPatient(String nationalCode,Date startDate) throws Exception{
        Assign assign=checkAssign(startDate);
        Patient patient=checkPatientWithNationalCode(nationalCode);
        if(patient==null){
            throw new Exception("There is no patient with this national code");
        }
        else if(assign==null){
            throw new Exception("There is no assign in this date.");
        }else if(assign!=null && patient!=null && assign.getPatient()!=null){
            throw new Exception("This date has been used by another patient");

        } else if(patient!=null && assign!=null && assign.getPatient()==null){
            assign.setPatient(patient);
        }

    }

}


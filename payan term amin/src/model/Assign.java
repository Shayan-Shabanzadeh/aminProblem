package model;

import java.util.Date;

public class Assign {
    private Patient patient;
    private String AssignId;
    private Date startDate;
    private Date endDate;

    public Assign( Date startDate,Date endDate) {
        this.patient = null;
        this.setAssignId();
        this.startDate=startDate;
        this.endDate=endDate;
    }



    private void setAssignId(){
       int assignIdNumber= DataBase.getDataBase().getAssigns().size();
       this.AssignId= String.valueOf(assignIdNumber);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAssignId() {
        return AssignId;
    }

}

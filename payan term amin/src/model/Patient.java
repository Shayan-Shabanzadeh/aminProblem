package model;

import java.util.Date;

public class Patient {
    private String patientsId;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String telephoneNumber;

    public Patient(String firstName, String lastName, String nationalCode, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.telephoneNumber = telephoneNumber;
        this.setPatientsId();
    }

    public String getPatientsId() {
        return patientsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    private void setPatientsId(){
        int patientsIdNumber=DataBase.getDataBase().getPatients().size();
        this.patientsId= String.valueOf(patientsIdNumber);
    }

}

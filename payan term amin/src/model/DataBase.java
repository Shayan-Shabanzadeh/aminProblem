package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private static DataBase dataBase=new DataBase();

    public static DataBase getDataBase() {
        return dataBase;
    }

    private HashMap<String,Patient> patients;
    private ArrayList<Assign> assigns;

    private DataBase() {
        this.assigns=new ArrayList<>();
        this.patients=new HashMap<>();
    }

    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    public ArrayList<Assign> getAssigns() {
        return assigns;
    }

}

package view;

import controller.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Menu {
    protected String menuName;
    protected HashMap<Integer,Menu> subMenus;
    protected Menu parentMenu;
    private Scanner scanner=new Scanner(System.in);
    protected Controller controller=Controller.getController();

    public Menu(String menuName, Menu parentMenu) {
        this.menuName = menuName;
        this.parentMenu = parentMenu;
        this.subMenus=new HashMap<>();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getMenuName() {
        return menuName;
    }

    public HashMap<Integer,Menu> getSubMenus() {
        return subMenus;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public void show(){
        System.out.println(this.menuName+":");
        for (Integer subMenusNumber : subMenus.keySet()) {
            System.out.println(subMenusNumber+"."+subMenus.get(subMenusNumber).getMenuName());
        }
        if(this.parentMenu==null){
            System.out.println(subMenus.size()+1+".Exit");
        }else{
            System.out.println(subMenus.size()+1+".Back");
        }

    }
    public void execute(){
        int input;
        Menu nextMenu=null;
        while (true) {
            try {
                input =Integer.parseInt(inputFormatWithBoundary("\\d+", subMenus.size() + 1, "Please enter a number:"));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(input<subMenus.size()+1){
           nextMenu=subMenus.get(input);
        }else{
            if(this.parentMenu==null){
                System.exit(1);
            }else{
                nextMenu=parentMenu;
            }
        }
        nextMenu.show();
        nextMenu.execute();
    }

    public String inputFormatWithBoundary(String regex,int size,String helpText) throws Exception{
            String input=getInput("\\d+","Enter a number");
            int inputWithNumber=Integer.parseInt(input);
            if (inputWithNumber<=size && inputWithNumber>0){
                return input;
            }else{
                throw new Exception("Input is out of boundary.");
            }
        }

        public String getInput(String regex,String helpText) throws Exception{
            Pattern pattern = Pattern.compile(regex);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return input;
            } else {
                throw new Exception("Invalid input!");
            }
        }

    protected Date getDate(String input) throws Exception{

        SimpleDateFormat format=new SimpleDateFormat("YYYY/mm/dd-HH:mm");

        Date date=format.parse(input);
        return date;
    }


}

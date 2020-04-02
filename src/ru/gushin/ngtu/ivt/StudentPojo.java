package ru.gushin.ngtu.ivt;

/*
This file can be used for testing
 */

public class StudentPojo {
    private final String nationality="Russian";
    private String name;
    private String otherPersonalInfo;
    protected String nameOfUni;
    public StudentPojo(String name, String otherPersonalInfo, String nameOfUni) {
        this.name = name;
        this.otherPersonalInfo = otherPersonalInfo;
        this.nameOfUni = nameOfUni;
    }
    public String getName() {
        return name;
    }
    public String getOtherPersonalInfo() {
        return otherPersonalInfo;
    }
    public String getNameOfUni() {
        return nameOfUni;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOtherPersonalInfo(String otherPersonalInfo) {
        this.otherPersonalInfo = otherPersonalInfo;
    }
    public void setNameOfUni(String nameOfUni) {
        this.nameOfUni = nameOfUni;
    }
    static  void printInfo(){ System.out.println("Info"); }
}
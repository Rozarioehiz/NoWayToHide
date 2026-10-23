package com.lastma.data.models;

public class Driver {
    private String fullName;
    private String email;
    private  String carPlateNumber;
    private int id;
    private String password;


    public String getPassword() {
        return password;
    }



    public  String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public  String getEmail(){
        return email;
    }

    public  void setEmail(String email){
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getCarPlateNumber(){
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber){
        this.carPlateNumber = carPlateNumber;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}

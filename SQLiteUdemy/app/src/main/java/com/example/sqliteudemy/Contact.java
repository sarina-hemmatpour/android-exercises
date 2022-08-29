package com.example.sqliteudemy;

public class Contact {
    private int id;
    private String fullName;
    private String cellPhone;

    public Contact(String fullName, String cellPhone) {
        this.fullName = fullName;
        this.cellPhone = cellPhone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}

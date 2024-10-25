package com.mobileshopweb.dto.request;

public class EmployeeLoginRequest {
    private String employeeID;
    private String passWordAccount;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassWordAccount() {
        return passWordAccount;
    }

    public void setPassWordAccount(String passWordAccount) {
        this.passWordAccount = passWordAccount;
    }
}

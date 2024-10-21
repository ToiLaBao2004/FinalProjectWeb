package com.mobileshopweb.dto.request;

import java.time.LocalDate;

public class EmployeeUpdateRequest {
    private String nameEmployee;
    private LocalDate birthday;
    private String gender;
    private String addressEmployee;
    private String phoneNumber;
    private String roleEmployee;
    private String active;
    private String passWordAccount;

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleEmployee() {
        return roleEmployee;
    }

    public void setRoleEmployee(String roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPassWordAccount() {
        return passWordAccount;
    }

    public void setPassWordAccount(String passWordAccount) {
        this.passWordAccount = passWordAccount;
    }
}

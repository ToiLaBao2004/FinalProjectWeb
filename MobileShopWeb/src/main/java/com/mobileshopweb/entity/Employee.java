package com.mobileshopweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @Column(name = "EmployeeID", length = 5)
    private String employeeID;

    @Column(name = "NameEmployee", nullable = false, length = 50)
    private String nameEmployee;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @Column(name = "Gender", nullable = false, length = 3)
    private String gender;

    @Column(name = "AddressEmployee", nullable = false, length = 100)
    private String addressEmployee;

    @Column(name = "PhoneNumber", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "RoleEmployee", nullable = false, length = 50)
    private String roleEmployee;

    @Column(name = "Active", nullable = false, length = 1)
    private String active;

    @Column(name = "PassWordAccount", nullable = false, length = 20)
    private String passWordAccount;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Satwika
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String SocialSecurityNumber;
    private String Age;
    private String CurrentAddress;
    private String UnitNumber;
    private String street;
    private String city;
    private String State;
    private String zipCode;
    private String Address;
    private String DeptNumber;
    private String workstreet;
    private String workcity;
    private String WorkState;
    private String workzipCode;

    public String getCurrentAddress() {
        return CurrentAddress;
    }

    public void setCurrentAddress(String CurrentAddress) {
        this.CurrentAddress = CurrentAddress;
    }

    public String getUnitNumber() {
        return UnitNumber;
    }

    public void setUnitNumber(String UnitNumber) {
        this.UnitNumber = UnitNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDeptNumber() {
        return DeptNumber;
    }

    public void setDeptNumber(String DeptNumber) {
        this.DeptNumber = DeptNumber;
    }

    public String getWorkstreet() {
        return workstreet;
    }

    public void setWorkstreet(String workstreet) {
        this.workstreet = workstreet;
    }

    public String getWorkcity() {
        return workcity;
    }

    public void setWorkcity(String workcity) {
        this.workcity = workcity;
    }

    public String getWorkzipCode() {
        return workzipCode;
    }

    public void setWorkzipCode(String workzipCode) {
        this.workzipCode = workzipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) {
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }
    
     public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getWorkState() {
        return WorkState;
    }

    public void setWorkState(String WorkState) {
        this.WorkState = WorkState;
    }
    
    @Override
    public String toString(){
        return firstName;
    }
}

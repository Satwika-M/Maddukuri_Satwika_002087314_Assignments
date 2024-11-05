/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Satwika
 */
public class PersonDirectory {
    private ArrayList<Person> persons;
    
    public PersonDirectory(){
        this.persons = new ArrayList<Person>();
        
    }
    
    public ArrayList<Person> getPerson(){
        return persons;
    }
    
    
    public void SetPerson(ArrayList<Person> persons){
        this.persons = persons;
    }
    
  
    
    public Person addPerson(){
        Person p = new Person();
        persons.add(p);
        return p;
    }
    
    
    public void deletePerson(Person person){
        persons.remove(person);
    }
    
  
    
    public Person searchperson(String firstName){
        for(Person p : persons){
            if(p.getFirstName().contains(firstName)){
                return p;
            }
        } 
        return null;
    }
    
    public Person searchaddress(String currentAddress){
        for(Person p : persons){
            if(p.getFirstName().contains(currentAddress)){
                return p;
            }
        } 
        return null;
    }
}

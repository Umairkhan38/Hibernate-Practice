package org.example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//annotation to assign the class as entity
@Entity

//Annotation to assigning table name
@Table (name="Student_Details")
public class Student {
    //Assigning as id using annotation
    @Id
    private int id;
    @GeneratedValue

    private String name;
    private String city;

    private Certificate certi;



    public Certificate getCertificate() {
        return certi;
    }

    public void setCerti(Certificate certificate) {
        this.certi = certificate;
    }

    Student(int id, String name, String city){
        super();
        this.id = id;
        this.name = name;
        this.city = city;
    }

    Student(){
        super();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(String name){
        return name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    @Override
    public String toString() {
        return "{ id :"+this.id+" Name : "+this.name+" City: "+this.city+" }";
    }
}

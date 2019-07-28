package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class Alien {
    private int aid;
    private String aname;
    private String technology;


   /*@Qualifier("lap1")
   @Autowired
   private Laptop laptop; */

    public int getAid() {
        return aid;
    }


    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public void sayHey() {
        System.out.println("Alien says hi.");


    }
}

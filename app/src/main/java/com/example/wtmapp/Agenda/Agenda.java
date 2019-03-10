package com.example.wtmapp.Agenda;

public class Agenda  {

    String name;
    String description;
    int id_;
   // int image;

    public Agenda(String name, String version, int id_) {
        this.name = name;
        this.description = version;
        this.id_ = id_;
       // this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return description;
    }

//    public int getImage() {
//        return image;
//    }
//
//    public int getId() {
//        return id_;
//    }
}

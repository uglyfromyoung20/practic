package ru.ssau.tk.ugly.practic;

public class Person {
    private String name;
    private String secondname;
    private int id;


    public Person(String name, String secondname, int id) {
        this.name = name;
        this.secondname = secondname;
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getsecondname() {
        return secondname;
    }

    public void setsecondname(String secondname) {
        this.secondname = secondname;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }


}




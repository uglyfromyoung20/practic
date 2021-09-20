package ru.ssau.tk.ugly.practic;

public class Main {

    public static void main(String[] args) {
        Person ivan = new Person("ivan", "ivanov", 34);
        String ivanname = ivan.getname();
        String ivansecondname = ivan.getsecondname();
        int id = ivan.getid();

        System.out.println("Имя:" + ivanname);
        System.out.println("Фамилия:" + ivansecondname);
        System.out.println("ID:" + id);



        Person alex = new Person("hehe", "Siiiii", 34);
        String alexname = alex.getname();
        String alexsecondname = alex.getsecondname();
        int idi = alex.getid();

        System.out.println("Имя:" + alexname);
        System.out.println("Фамилия:" + alexsecondname);
        System.out.println("ID:" + id);

    }




}
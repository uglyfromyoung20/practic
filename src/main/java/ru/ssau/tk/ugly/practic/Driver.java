package ru.ssau.tk.ugly.practic;

import ru.ssau.tk.ugly.practic.Gender;

import java.util.Date;
import java.util.Objects;

public final class Driver {
    private int id;
    private String name;
    private Gender gender;
    private Date licenseExpirationDate;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setLicenseExpirationDate(Date licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public Date getLicenseExpirationDate() {
        return licenseExpirationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id && Objects.equals(name, driver.name) && gender == driver.gender && Objects.equals(licenseExpirationDate, driver.licenseExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, licenseExpirationDate);
    }

    @Override
    public String toString() {
        return "Водитель\n" + "Идентификатор: " + id + "\nИмя: " + name + "\nГендер: " + gender + "\nСрок окончания действия лицензии: " + licenseExpirationDate + '\n';
    }
}
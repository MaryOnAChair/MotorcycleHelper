package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity

public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long OwnerId;

    private String Brand;
    private String Model;
    private String Color;

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    private int Year;
    private Date dateChainCleaned;
    private Date lastOilChangeDate;
    private String notes;

    public Long getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(Long ownerId) {
        OwnerId = ownerId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Date getDateChainCleaned() {
        return dateChainCleaned;
    }

    public void setDateChainCleaned(Date dateChainCleaned) {
        this.dateChainCleaned = dateChainCleaned;
    }

    public Date getLastOilChangeDate() {
        return lastOilChangeDate;
    }

    public void setLastOilChangeDate(Date lastOilChangeDate) {
        this.lastOilChangeDate = lastOilChangeDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

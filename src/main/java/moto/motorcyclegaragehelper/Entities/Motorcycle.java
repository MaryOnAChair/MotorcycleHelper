package moto.motorcyclegaragehelper.Entities;

import jakarta.persistence.*;

import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "motorcycles")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moto_id")
    private Long id;


    @Column(name = "Brand")
    private String Brand;
    @Column(name = "Model")
    private String Model;
    @Column(name = "Color")
    private String Color;

    @Column(name = "Year")
    private Year Year;
    @Column(name = "lastOilChangeDate")
    private Date lastOilChangeDate;


    public Year getYear() {
        return Year;
    }

    public void setYear(Year year) {
        Year = year;
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

    public void motorcycle(){
        this.setYear(Year);
        this.setBrand(Brand);
        this.setModel(Model);
        this.setColor(Color);
        this.setLastOilChangeDate(lastOilChangeDate);
    }

    public Date getLastOilChangeDate() {
        return lastOilChangeDate;
    }

    public void setLastOilChangeDate(Date lastOilChangeDate) {
        this.lastOilChangeDate = lastOilChangeDate;
    }

}

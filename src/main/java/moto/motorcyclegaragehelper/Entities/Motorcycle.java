package moto.motorcyclegaragehelper.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "motorcycles")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moto_id")
    private Long moto_id;


    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private int year;
    @Column(name = "last_Oil_Change_Date")
    private String last_Oil_Change_Date;


   public Motorcycle( String brand, String model, String color, int year ) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Motorcycle() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        color = color;
    }

    public void motorcycle(){
        this.setYear(year);
        this.setBrand(brand);
        this.setModel(model);
        this.setColor(color);
        this.setLastOilChangeDate(last_Oil_Change_Date);
    }

    public String getLastOilChangeDate() {
        return last_Oil_Change_Date;
    }

    public void setLastOilChangeDate(String lastOilChangeDate) {
        this.last_Oil_Change_Date = lastOilChangeDate;
    }

}

package moto.motorcyclegaragehelper.Entities;

import jakarta.persistence.*;

/** This is an Entity class for motorcycles
 * The class is used for storing data in its column
 * Each column has its respective getters and setters*/

@Entity
@Table(name = "motorcycles")
public class Motorcycle {
    public Long getMoto_id() {
        return moto_id;
    }

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
    private Integer year;

    @Column(name = "vin")
    private Number vin;

    @Column(name = "odometer")
    private Number odometer;

    public Number getOdometer() {
        return odometer;
    }

    public void setOdometer(Number odometer) {
        this.odometer = odometer;
    }

    //Joins Motorcycles to one user
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Number getVin() {
        return vin;
    }

    public void setVin(Number vin) {
        this.vin = vin;
    }

    public Motorcycle(String brand, String model, String color, Integer year, Long moto_id, Integer vin  ,Integer odometer) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.moto_id = moto_id;
        this.vin = vin;
        this.odometer = odometer;
    }

    public Motorcycle() {

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setMoto_id(Long moto_id) {
        this.moto_id = moto_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {

       this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void motorcycle(){
        this.setYear(year);
        this.setBrand(brand);
        this.setModel(model);
        this.setColor(color);
        this.setVin(vin);
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}

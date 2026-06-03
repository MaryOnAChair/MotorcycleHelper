package moto.motorcyclegaragehelper.Entities;

import jakarta.persistence.*;

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
    @Column(name = "last_Oil_Change_Date")
    private String last_Oil_Change_Date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


   public Motorcycle( String brand, String model, String color, Integer year,Long moto_id,String last_Oil_Change_Date ) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.moto_id = moto_id;
        this.last_Oil_Change_Date = last_Oil_Change_Date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLast_Oil_Change_Date() {
        return last_Oil_Change_Date;
    }

    public void setLast_Oil_Change_Date(String last_Oil_Change_Date) {
        this.last_Oil_Change_Date = last_Oil_Change_Date;
    }
}

package ua.com.owu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String pName;
    private String pType;

    public Product() {
    }

    public Product(String pName, String pType) {
        this.pName = pName;
        this.pType = pType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pType='" + pType + '\'' +
                '}';
    }
}

package com.example.demo.com.example.demo;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="ProductTable")
public class Product {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;


    private String nameOfProduct;
    private BigDecimal priceOfProduct;
    private String category;
    private String subCategory;

    private String imageName;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public BigDecimal getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(BigDecimal priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.ID &&
                priceOfProduct == product.priceOfProduct &&
                Objects.equals(nameOfProduct, product.nameOfProduct) &&
                Objects.equals(category, product.category) &&
                Objects.equals(subCategory, product.subCategory) &&
                Objects.equals(imageName, product.imageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nameOfProduct, priceOfProduct, category, subCategory, imageName);
    }
}

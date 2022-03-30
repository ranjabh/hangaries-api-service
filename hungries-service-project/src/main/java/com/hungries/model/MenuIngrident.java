package com.hungries.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MENU_INGREDIENT_MASTER")
public class MenuIngrident{
    @Id
    @GeneratedValue
    private long id;
    @Column(name="sub_product_id")
    private String subProductId;
    @Column(name="product_id")
    private String productId;
    @Column(name="ingredient_type")
    private String ingredientType;
    @Column(name="price")
    private double price;
    @Column(name="category")
    private String category;
    @Column(name="imagepath")
    private  String imagePath;
    @Column(name="ingredient_available_flag")
    private String ingredientAvaliableFalg;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="updated_by")
    private String updatedBy;
    @Column(name="updated_date")
    private Date updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIngredientAvaliableFalg() {
        return ingredientAvaliableFalg;
    }

    public void setIngredientAvaliableFalg(String ingredientAvaliableFalg) {
        this.ingredientAvaliableFalg = ingredientAvaliableFalg;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "MenuIngridentMaster{" +
                "id=" + id +
                ", subProductId='" + subProductId + '\'' +
                ", productId='" + productId + '\'' +
                ", ingredientType='" + ingredientType + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredientAvaliableFalg='" + ingredientAvaliableFalg + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
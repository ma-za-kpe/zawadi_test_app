package com.maku.zawaditestapp.model;

public class restaurants {

    private String id;

    private String restaurant;

    private String location;

    private String formule;

    private String category;

    private String food;

    private boolean done;

    private String createdAt;

    private String updatedAt;

    private String UserId;


    public restaurants() {
        this.id = id;
        this.restaurant = restaurant;
        this.location = location;
        this.formule = formule;
        this.category = category;
        this.food = food;
        this.done = false;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        UserId = null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getId() {
        return id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return restaurant;
    }

    public String getLocation() {
        return location;
    }

    public String getFormule() {
        return formule;
    }

    public String getCategory() {
        return category;
    }

    public String getFood() {
        return food;
    }

    public boolean isDone() {
        return done;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUserId() {
        return UserId;
    }
}

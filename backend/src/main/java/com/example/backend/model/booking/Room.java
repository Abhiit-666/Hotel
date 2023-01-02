package com.example.backend.model.booking;

public class Room {
    private Long id;
    private String name;
    private int capacity;
    private double pricePerNight;

    public Room(Long id, String name, int capacity, double pricePerNight) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public Room() {
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @param pricePerNight the pricePerNight to set
     */
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;

    }

    /**
     * @return int return the capacity
     */

    public int getCapacity() {
        return capacity;
    }

    /**
     * @return double return the pricePerNight
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", capacity='" + getCapacity() + "'" +
                ", pricePerNight='" + getPricePerNight() + "'" +
                "}";
    }

}

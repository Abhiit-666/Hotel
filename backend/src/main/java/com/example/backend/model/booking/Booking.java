package com.example.backend.model.booking;

import java.util.Date;

public class Booking {
    private Long id;
    private Room room;
    private Date startDate;
    private Date endDate;
    private double totalPrice;

    public Booking(Long id, Room room, Date startDate, Date endDate, double totalPrice) {
        this.id = id;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public Booking() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Room return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return Date return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Date return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return double return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", room='" + getRoom() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                ", totalPrice='" + getTotalPrice() + "'" +
                "}";
    }

}

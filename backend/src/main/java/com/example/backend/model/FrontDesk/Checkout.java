package com.example.backend.model.FrontDesk;

import java.time.LocalDate;
import java.util.Date;

public class Checkout {
    private long roomNumber;
    private String customerName;
    private Date checkoutDate;

    public Checkout() {
    }

    public Checkout(long roomNumber, String customerName, Date checkoutDate) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.checkoutDate = checkoutDate;
    }

    /**
     * @return long return the roomNumber
     */
    public long getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return String return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return Date return the checkoutDate
     */
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutDate the checkoutDate to set
     */
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public String toString() {
        return "{" +
                " roomNumber='" + getRoomNumber() + "'" +
                ", customerName='" + getCustomerName() + "'" +
                ", checkoutDate='" + getCheckoutDate() + "'" +
                "}";
    }

}

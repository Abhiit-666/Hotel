package com.example.backend.model.FrontDesk;

public class CustQuery {
    private String customerName;
    private String query;

    public CustQuery() {
    }

    public CustQuery(String customerName, String query) {
        this.customerName = customerName;
        this.query = query;
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
     * @return String return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "{" +
                " customerName='" + getCustomerName() + "'" +
                ", query='" + getQuery() + "'" +
                "}";
    }

}

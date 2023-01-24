package com.example.backend.Service.FrontDesk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.backend.model.FrontDesk.Checkout;
import com.example.backend.model.FrontDesk.CustQuery;

@Service
public class FrontDeskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void handleQuery(CustQuery custquery) {
        String sql = "insert into queries (`customer_name, query) values (?,?)";
        jdbcTemplate.update(sql, custquery.getCustomerName(), custquery.getQuery());
    }

    public List<CustQuery> getallQueries() {
        String sql = "select * from queries";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new CustQuery(rs.getString("customer_name"),
                rs.getString("query")));
    }

    public List<CustQuery> GetQueryByCustomerName(String customerName) {
        String sql = "select * from queries where customer_name=:customerName";
        Map<String, Object> params = new HashMap<>();
        params.put("customerName", customerName);
        // rs is the current row in the resultset and rownum is the number of the
        // current row; starting from 0
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.query(sql, params,
                (rs, rowNum) -> new CustQuery(rs.getString("customer_name"), rs.getString("query")));
    }

    // This method needs further evaluation and modification
    public int handleCheckout(Checkout request) throws ParseException {
        // fetch total expence for the customer and the end date for the customer.
        // Recalculate expense if the checkout date is in the future compared to the
        // initial booking end date
        String sql = "select totalPrice,endDate from bookings where customer_name=? and room=?";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, request.getCustomerName(), request.getRoomNumber());
        int totalExpenses = (int) result.get("totalPrice");
        // casting to string becasue its an object in the map ?
        LocalDate endDate = LocalDate.parse((String) result.get("endDate"));
        // request class returns a Date; hence converting it to a LocalDate as it is
        // more Thread safe
        Date d_checkoutDate = request.getCheckoutDate();
        Instant instant = d_checkoutDate.toInstant();
        LocalDate checkoutDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();

        // check if the checkout date is the same or more than the booking end date.
        if (endDate.isBefore(checkoutDate)) {
            // get the updated price for the room with the checkout date.
            totalExpenses = 0;
        }

        // removing customer from the bookings db
        String sql2 = "delete from bookings where customer_name=? and room=?";
        jdbcTemplate.update(sql2, request.getCustomerName(), request.getRoomNumber());

        return totalExpenses;

    }

    // will have to add billing fuctionality after checkout
}

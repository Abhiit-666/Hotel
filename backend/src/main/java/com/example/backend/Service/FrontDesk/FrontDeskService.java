package com.example.backend.Service.FrontDesk;

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
    public int handleCheckout(Checkout request) {
        // fetch total expence for the customer
        Map<String, Object> params = new HashMap<>();
        params.put("customerName", request.getCustomerName());
        String sql = "Select end_date From booking where customer_name=:customerName";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        Date end_date = namedParameterJdbcTemplate.query(sql, params);

    }
}

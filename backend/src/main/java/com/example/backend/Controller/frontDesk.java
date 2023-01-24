package com.example.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend.model.FrontDesk.Checkout;
import com.example.backend.model.FrontDesk.CustQuery;

@RequestMapping("/frontdesk")
public class frontDesk {

    @PostMapping("/query")
    public ResponseEntity<?> handleQuery(@RequestBody CustQuery query) {
        // code to control customer queries
        return null;
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> handleCheckout(@RequestBody Checkout request) {
        // code to handle checkout
        return null;
    }

}

package com.example.backend.Controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.booking.Booking;

@RestController
@RequestMapping("/booking")
public class controller {

    @GetMapping("/availability")
    public List<Random> getAvailability(@RequestParam Date startDate, @RequestParam Date endDate) {
        // code to check availibility
        return null;
    }

    @PostMapping("/book")
    public Booking bookRoom(@RequestBody Booking booking) {
        return booking;
        // code to book room
    }

    @GetMapping("/price")
    public double getPrice(@RequestBody Long roomId, @RequestParam Date startDate, @RequestParam Date endDate) {
        return 0.0;
        // code to get price
    }

}

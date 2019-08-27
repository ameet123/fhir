package com.ameet.fhir.controller;

import com.ameet.fhir.model.Hospital;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FhirController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hospital")
    public Hospital hospital(@RequestParam(value = "name", defaultValue = "Northside") String name) {
        return new Hospital(String.valueOf(counter.incrementAndGet()), name);
    }
}

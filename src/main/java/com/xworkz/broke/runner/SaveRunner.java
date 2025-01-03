package com.xworkz.broke.runner;

import com.xworkz.broke.service.EcommerceService;
import com.xworkz.broke.service.EcommerceServiceImpl;

import java.time.LocalDate;

public class SaveRunner {
    private static EcommerceService ecommerceService = new EcommerceServiceImpl();

    public static void main(String[] args) {
        boolean validateAndSave = ecommerceService.validateAndSave("", "", "", LocalDate.now(), 0.0, "");
        if (validateAndSave) {
            System.out.println("data saved successfully");
        } else {
            System.out.println("data is not saved check validation");
        }

    }
}

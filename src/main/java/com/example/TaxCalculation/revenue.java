package com.example.TaxCalculation;


import jakarta.jws.WebService;

import javax.xml.ws.Endpoint;


@WebService
public class revenue {
    public static double calculatePersonalTax(double income) {
        double tax = 0;
        income = income-60000;
        if (income <= 36000) {
            tax = income * 0.03;
        } else if (income <= 144000 && income > 36000) {
            tax =income * 0.1 - 2520;
        } else if (income <= 300000&&income > 144000) {
            tax = income * 0.2 - 16920;
        } else if (income <= 420000 && income > 300000) {
            tax = income * 0.25 - 31920;
        } else if (income <= 660000 && income > 420000) {
            tax = income * 0.3 - 52920;
        } else if (income <= 960000 && income > 660000) {
            tax = income  * 0.35 - 85920;
        } else {
            tax = income * 0.45 - 181920;
        }
        Endpoint.publish("http://localhost:8080/TaxCalculation/tax", tax);

        return tax;
    }


}

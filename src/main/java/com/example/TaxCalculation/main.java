package com.example.TaxCalculation;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


public class main {
    public static void main(String[] args) {


        Endpoint.publish("http://localhost:8080/TaxCalculation", new TaxCalculationServiceImpl());
        System.out.println("发布成功！");
    }
}

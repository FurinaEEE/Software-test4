package com.example.TaxCalculation;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface TaxCalculationService {
    @WebMethod
    double TaxCalculationIncomeTax(double income);
}

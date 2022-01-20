package com.company.jmixrestsample.app;

import com.company.jmixrestsample.entity.Order;

import java.time.LocalDate;

public interface OrderService {

    public Double calculatePrice();

    public OrderValidationResult validateOrder(Order order, LocalDate validationDate);
}

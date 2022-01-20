package com.company.jmixrestsample.app;

import com.company.jmixrestsample.entity.Order;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

    @Service(OrderServiceBean.NAME)
    public class OrderServiceBean implements OrderService {
        public static final String NAME = "sales_OrderServiceBean";

        @Autowired
        DataManager dataManager;

        @Override
        public Double calculatePrice() {
            return dataManager.loadValue(
                    "select sum(o.amount) from sales_Order o ",
                    Double.class)
                    .one();
        }

        @Override
        public OrderValidationResult validateOrder(Order order, LocalDate validationDate) {
            OrderValidationResult result = new OrderValidationResult();
            result.setSuccess(false);
            result.setErrorMessage("Validation of order " + order.getNumberOfSpecialProducts()
                    + " failed. validationDate parameter is: " + validationDate);
            return result;
        }
    }
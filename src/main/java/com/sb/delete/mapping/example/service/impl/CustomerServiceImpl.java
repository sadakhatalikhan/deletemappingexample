package com.sb.delete.mapping.example.service.impl;

import com.sb.delete.mapping.example.model.CustomerModel;
import com.sb.delete.mapping.example.response.APIResponse;
import com.sb.delete.mapping.example.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static List<CustomerModel> customers = new ArrayList<>();
    private static AtomicInteger c = new AtomicInteger(1);

    static {
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser1", 21, "7234567811", "testuser1@gmail.com", "Bangalore", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser2", 22, "7234567812", "testuser2@gmail.com", "Hyderabad", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser3", 23, "7234567813", "testuser3@gmail.com", "Chennai", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser4", 24, "7234567814", "testuser4@gmail.com", "Pune", LocalDate.now()));
    }

    @Override
    public ResponseEntity<APIResponse> deleteByCustomerId(long customerId) {

        boolean isRemoved = customers.removeIf(customerModel -> customerModel.getCustomerId() == customerId);

        if (isRemoved) {
            return ResponseEntity.ok(
                    APIResponse.builder()
                            .errorCode(0)
                            .data("Successfully Removed")
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    APIResponse.builder()
                            .errorCode(999)
                            .data("Customer is not available")
                            .build()
            );
        }
    }
}

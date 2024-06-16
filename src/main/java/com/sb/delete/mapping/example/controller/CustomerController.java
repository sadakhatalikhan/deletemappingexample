package com.sb.delete.mapping.example.controller;

import com.sb.delete.mapping.example.response.APIResponse;
import com.sb.delete.mapping.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @DeleteMapping("/deleteById/{customerId}")
    public ResponseEntity<APIResponse> deleteByCustomerId(@PathVariable long customerId) {
        return customerService.deleteByCustomerId(customerId);
    }
}

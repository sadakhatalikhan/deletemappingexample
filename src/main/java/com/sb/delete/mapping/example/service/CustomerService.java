package com.sb.delete.mapping.example.service;

import com.sb.delete.mapping.example.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<APIResponse> deleteByCustomerId(long customerId);
}

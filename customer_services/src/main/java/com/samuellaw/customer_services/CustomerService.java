/*
 * Requirements:
 * - Service layer wrapping CustomerRepository
 * - Provides: findAll, findById, findByUserId, save, deleteById
 */
package com.samuellaw.customer_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public Optional<CustomerEntity> findByLoginId(String loginId) {
        return customerRepository.findByLoginId(loginId);
    }

    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

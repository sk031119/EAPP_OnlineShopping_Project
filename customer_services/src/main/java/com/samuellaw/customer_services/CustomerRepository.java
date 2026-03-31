/*
 * Requirements:
 * - JPA repository for CustomerEntity
 * - findByUserId: lookup customer by their linked web_client user id
 */
package com.samuellaw.customer_services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByUserId(Long userId);
}

/*
 * Requirements:
 * - JPA entity mapped to "customer" table in H2 DB
 * - id: auto-generated primary key
 * - userId: links to web_client WebUserEntity (the login user's id)
 * - Stores first name, last name, email, phone, address
 */
package com.samuellaw.customer_services;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK reference to web-user WebUser's loginId (String PK)
    private String loginId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public CustomerEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

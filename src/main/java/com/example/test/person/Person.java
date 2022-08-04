package com.example.test.person;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private Long subscriptionTo[];
    private Long subscriptionFrom[];
    private Date created;

    @Transient
    private int age;
    private LocalDate dob;

    public Person() {
    }

    public Person(String username, String firstname, String lastname, String password, String email, LocalDate dob) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.created = new Date();
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long[] getSubscriptionTo() {
        return subscriptionTo;
    }

    public void setSubscriptionTo(Long[] subscriptionTo) {
        this.subscriptionTo = subscriptionTo;
    }

    public Long[] getSubscriptionFrom() {
        return subscriptionFrom;
    }

    public void setSubscriptionFrom(Long[] subscriptionFrom) {
        this.subscriptionFrom = subscriptionFrom;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

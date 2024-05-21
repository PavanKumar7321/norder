package com.ensar.norder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    public enum UserStatus {
        pending,
        banned,
        rejected,
        active
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "disabled")
    private boolean disabled;

    
    //@Column(name = "last_login_date_time")
    //private Timestamp lastLoginDateTime;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('pending', 'banned', 'rejected', 'active') default 'active'")
    private UserStatus status;

    @Column(name = "is_verified", nullable = false,  columnDefinition = "boolean default false")
    private Boolean isVerified;

    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String company;
    private String phoneNumber;
    private String avatarUrl;
    private String coverUrl;
    private String about;
    private int totalFollowers;
    private int totalFollowing;
    private String team;

    @OneToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
          joinColumns = @JoinColumn(name = "user_id"), 
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
  
}



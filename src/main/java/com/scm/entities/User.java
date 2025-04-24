package com.scm.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 1000)
    private String about;
    @Column(name = "profile_picture", length = 1000)
    private String profilePic;
    private String phoneNumber;

    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

}

// Hibernate notes:
// mappedBy:
// if we dont provide the mappedBy attribute, we have to do bidirectional
// mapping, and it requires one more variable which will be annotated by
// @ManyToOne in Contact class.
// So to avoid it and do single-directional mapping we use mappedBy attribute
// and provide a variable name by which we are doing mapping.

// cascade:
// CascadeType.All attribute helps Hibernate to tell that delete all the
// contacts related to the user if we will delete the user.

// fetch:
// FetchType.LAZY tells Hibernate that when we fetch the user details don't
// fetch the details of his contacts till we need.
// FetchType.EAGER tells Hibernate that when we fetch the user details
// immediately fetch the details of his socialMediaLinks.

// orphanRemoval:
// removes the unmapped elements from contacts table.
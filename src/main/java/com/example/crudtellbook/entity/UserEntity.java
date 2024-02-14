package com.example.crudtellbook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user", schema = "telbook")
public class UserEntity {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_id_seq", schema = "telbook", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "second_phone_number")
    private String secondPhoneNumber;

    @Column(name = "date_create", updatable = false)
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @PrePersist
    public void toCreate() {
        setDateCreate(LocalDateTime.now());
        setDateUpdate(getDateCreate());
    }

    @PreUpdate
    public void toUpdate() {
        setDateUpdate(LocalDateTime.now());
    }


}

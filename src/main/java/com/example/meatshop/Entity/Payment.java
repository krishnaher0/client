package com.example.meatshop.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table
@Entity
@Setter
@Getter
public class Payment {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Items items;
    @Column(
            name = "Type"
    )
    private String type;
    @Column(
            name = "Amount"
    )
    private String amount;
    @Column(
            name = "Date"
    )
    private LocalDate date;
}

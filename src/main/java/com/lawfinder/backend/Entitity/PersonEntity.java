package com.lawfinder.backend.Entitity;
import jakarta.persistence.*;

@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "ADRESS_ID", referencedColumnName = "ADRESS_ID")
    private AddressEntity address;

    
}

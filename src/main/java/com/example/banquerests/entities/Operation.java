package com.example.banquerests.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1)
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;

    public Operation(Date dateOperation, double montant) {
        this.dateOperation = dateOperation;
        this.montant = montant;
    }
}

package com.example.banquerests.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE" , discriminatorType = DiscriminatorType.STRING, length = 2)
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public abstract class Compte implements Serializable
{   @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte(String codeCompte, Date dateCreation, double solde) {
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }
}

package com.example.banquerests.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP" , discriminatorType = DiscriminatorType.STRING, length = 4)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME ,include = JsonTypeInfo.As.PROPERTY,property = "type_op")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(name = "V(+)", value = Versement.class),
                @JsonSubTypes.Type(name = "R(-)", value = Retrait.class)
        }
)
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public abstract class Operation implements Serializable {
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

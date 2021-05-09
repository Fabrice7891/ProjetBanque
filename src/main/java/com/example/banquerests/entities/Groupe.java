package com.example.banquerests.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "GROUPES")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeGpe;
    private String nomGroupe;
    @ManyToMany(mappedBy = "groupes")
    private Collection<Employe> employes;

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}

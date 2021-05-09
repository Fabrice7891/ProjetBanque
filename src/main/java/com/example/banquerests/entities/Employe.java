package com.example.banquerests.entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEmploye;
    private String nomEmploye;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP_SUP")
    private Employe employeSup;
    @ManyToMany
    @JoinTable(name = "EMP_GPE")
    private Collection<Groupe> groupes;

    @Ignore
    public Employe getEmployeSup() {
        return employeSup;
    }

    @JsonSetter
    public void setEmployeSup(Employe employeSup) {
        this.employeSup = employeSup;
    }

    @Ignore
    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public Employe(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
}

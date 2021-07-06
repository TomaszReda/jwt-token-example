package pl.test.jwttokenexample.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "role")
public class DAORole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;

    public DAORole(String name) {
        this.name = name;
    }

    public DAORole() {
    }
}
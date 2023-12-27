package com.example.spring5webapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"talks","firstName","lastName", "congregation"})
@ToString(exclude = {"talks"})
@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "speakers", cascade = CascadeType.ALL)
    private Set<Talk> talks = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "congregation_id")
    private Congregation congregation;
}

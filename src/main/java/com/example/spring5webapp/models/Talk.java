package com.example.spring5webapp.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"speakers","talkNumber","talkName"})
@ToString
@Entity
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String talkNumber;
    private String talkName;

    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private Speaker speakers;
}

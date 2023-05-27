package com.prime.shorturl.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="shorturl")
public class Redirect {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id",updatable = false, nullable = false, unique = true)
    private Long id;

@NaturalId
@Column(unique = true,nullable = false)
    private String alias;

@Column(nullable = false)
    private  String url;

    public Redirect(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }
}

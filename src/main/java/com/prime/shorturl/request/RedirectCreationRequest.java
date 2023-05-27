package com.prime.shorturl.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@ToString
public class RedirectCreationRequest {

    @NotNull
    private String alias;

    @NotNull
    private  String url;
}

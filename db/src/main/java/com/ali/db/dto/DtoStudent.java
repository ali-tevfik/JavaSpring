package com.ali.db.dto;

import java.util.List;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
    private String firstName;
    private String lastName;

    @ManyToMany
    private List<DtoCourse> dtoCourses;
}

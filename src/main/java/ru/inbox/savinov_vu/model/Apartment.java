package ru.inbox.savinov_vu.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "dict_Apartment")
public class Apartment {

    @Id
    private String id = String.valueOf(UUID.randomUUID());
    private String is_deleted = "0";
    private Date last_update;
    private String name;
    private String full_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buildingId", nullable = false)
    private Home buildingId;



    public Apartment(String apartmentName, Home home) {
        apartmentName = apartmentName.trim();
        this.name = apartmentName;
        this.buildingId = home;
        this.full_name = buildingId.getFull_name() + " - " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(full_name, apartment.full_name.trim().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), full_name.trim().toLowerCase());
    }
}

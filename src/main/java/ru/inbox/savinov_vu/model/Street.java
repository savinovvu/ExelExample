package ru.inbox.savinov_vu.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "dict_street")
public class Street {

    @Id
    private String id = String.valueOf(UUID.randomUUID());
    private Boolean is_deleted = false;
    private Date last_update;
    private String name;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "streetId")
    private List<Home> homes;

    public Street(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

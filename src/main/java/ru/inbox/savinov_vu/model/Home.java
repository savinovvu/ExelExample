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
@Table(name = "dict_building")
public class Home {

    @Id
    private String id = String.valueOf(UUID.randomUUID());
    private Boolean is_deleted = false;
    private Date last_update;
    private String name;
    private String full_name;
    private String management_company;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "streetId", nullable = false)
    private Street streetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(name, home.name) &&
                Objects.equals(streetId, home.streetId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, streetId);
    }
}

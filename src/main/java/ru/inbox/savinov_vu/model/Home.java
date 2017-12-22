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

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "homes")
    private List<Home> homes;

    public Home(String name, Street streetId, String management_company) {

        if (streetId == null) {
            throw new IllegalArgumentException("нет улицы");
        }
        name = name.trim();
        this.name = name;
        this.streetId = streetId;
        this.management_company = management_company;
        full_name = streetId + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Home home = (Home) o;
        return Objects.equals(full_name, home.full_name.trim().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), full_name.trim().toLowerCase());
    }
}

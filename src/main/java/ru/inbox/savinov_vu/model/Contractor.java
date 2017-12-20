package ru.inbox.savinov_vu.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "dict_contractor")
public class Contractor {

    @Id
    private UUID id = UUID.randomUUID();
    private Boolean is_deleted = false;
    private Boolean is_group;
    private String parent_id;
    private String name;
//    private String description;
    private String topdepartment_id;
    private String contractor_type = "LEGAL";
    private String inn;
    private String category = "OTHER";
    @OrderBy
    private Date last_update = new Date();
    private String code;

    public Contractor(String name) {
        this.name = name;
    }
}

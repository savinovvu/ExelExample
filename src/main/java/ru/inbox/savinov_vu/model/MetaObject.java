package ru.inbox.savinov_vu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.inbox.savinov_vu.commonInterfaces.Identify;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "sysobject")
public class MetaObject implements Identify {

    @Id
    private String id ;
    private Boolean is_deleted = false;
    private String type;
    private Date last_update = new Date();

    public MetaObject(String id,  String type) {
        this.id = id;
        this.type = type;
    }
}

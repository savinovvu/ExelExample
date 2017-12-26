package ru.inbox.savinov_vu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.inbox.savinov_vu.commonInterfaces.Identify;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
//@Table(name = "")
public class MetaObject implements Identify {

    @Id
    private String id ;
    private String is_deleted = "0";
    private String type;
}

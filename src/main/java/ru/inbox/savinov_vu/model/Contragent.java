package ru.inbox.savinov_vu.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.inbox.savinov_vu.commonInterfaces.Identify;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "dict_contractor")
public class Contragent  implements Identify {

    @Id
    private String id = String.valueOf(UUID.randomUUID());
    private String is_deleted = "0";
    private Date last_update;


}

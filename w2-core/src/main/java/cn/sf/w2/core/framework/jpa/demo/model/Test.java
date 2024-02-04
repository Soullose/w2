package cn.sf.w2.core.framework.jpa.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_test")
public class Test {

    @Id
    @Column(name = "id_")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "name_")
    private String name;
}

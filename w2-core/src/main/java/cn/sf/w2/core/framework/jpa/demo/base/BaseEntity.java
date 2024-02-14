package cn.sf.w2.core.framework.jpa.demo.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy"), })
	@Column(name = "id_")
	private String Id;
}

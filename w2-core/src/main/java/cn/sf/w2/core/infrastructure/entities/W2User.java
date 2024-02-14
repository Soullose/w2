package cn.sf.w2.core.infrastructure.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.sf.w2.core.framework.jpa.demo.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_w2_user")
public class W2User extends BaseEntity {

	@Column(name = "email_")
	private String email;

	@JsonIgnore
	@Column(name = "password_")
	private String password;

	@JsonCreator
	public W2User(String id,String email,String password){
		this.setId(id);
		this.email = email;
		this.password = password;
	}
}

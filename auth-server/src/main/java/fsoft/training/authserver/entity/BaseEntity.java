package fsoft.training.authserver.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//@Data
@AllArgsConstructor
public abstract class BaseEntity {
	
	@Column(name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

	public BaseEntity(Class<BaseEntity> baseEntityClass) {
	}

	public BaseEntity() {
	}
}

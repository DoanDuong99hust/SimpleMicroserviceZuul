package fsoft.training.authserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<UserEntity> users = new HashSet<>();

	@OneToMany(mappedBy = "roleEntity")
	private List<PermissionEntity>permissionList= new ArrayList<>();

	public RoleEntity() {

	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public List<PermissionEntity> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}
}
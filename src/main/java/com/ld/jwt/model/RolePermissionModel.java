package com.ld.jwt.model;

public class RolePermissionModel {
	
	private String name;
	private String permission_name;
	
	public RolePermissionModel() {}

	public RolePermissionModel(String name, String permission_name) {
		this.name = name;
		this.permission_name = permission_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

}

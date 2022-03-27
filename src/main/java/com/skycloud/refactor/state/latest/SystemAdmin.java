package com.skycloud.refactor.state.latest;

public class SystemAdmin extends SystemUser {

	public SystemAdmin(String id, String userName) {
		super(id, userName);
	}

	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}

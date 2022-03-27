package com.skycloud.refactor.state.latest;

public class SystemPermission {

	private SystemUser requestor;
	private SystemAdmin admin;
	private boolean isGranted;
	private PermissionState state;

	public SystemPermission(SystemUser requestor) {
		this.requestor = requestor;
		state = PermissionState.REQUESTED;
		isGranted = false;
	}

	public void claimedBy(SystemAdmin admin) {
		state.claimedBy(admin,this);
	}

	public void deniedBy(SystemAdmin admin) {
		state.deniedBy(admin,this);
	}

	public void grantedBy(SystemAdmin admin) {
		state.grantedBy(admin,this);
	}

	public PermissionState state() {
		return this.state;
	}

	public void setState(PermissionState state) {
		this.state = state;
	}

	public boolean isGranted() {
		return this.isGranted;
	}

	public SystemUser getRequestor() {
		return requestor;
	}

	public void setRequestor(SystemUser requestor) {
		this.requestor = requestor;
	}

	public SystemAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(SystemAdmin admin) {
		this.admin = admin;
	}

	public PermissionState getState() {
		return state;
	}

	public void setGranted(boolean isGranted) {
		this.isGranted = isGranted;
	}
	
	

}

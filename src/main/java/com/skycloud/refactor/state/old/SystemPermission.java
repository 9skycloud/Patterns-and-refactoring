package com.skycloud.refactor.state.old;

public class SystemPermission {

	private SystemUser requestor;
	private SystemAdmin admin;
	private boolean isGranted;
	private String state;

	public final static String REQUESTED = "REQUESTED";
	public final static String CLAIMED = "CLAIMED";
	public final static String GRANTED = "GRANTED";
	public final static String DENIED = "DENIED";

	public SystemPermission(SystemUser requestor) {
		this.requestor = requestor;
		state = REQUESTED;
		isGranted = false;
	}

	public void claimedBy(SystemAdmin admin) {
		if (!state.equals(REQUESTED))
			return;
		willBeHandledBy(admin);
		state = CLAIMED;
	}

	public void deniedBy(SystemAdmin admin) {
		if (!state.equals(CLAIMED))
			return;
		if (!this.admin.equals(admin))
			return;
		isGranted = false;
		state = DENIED;
		notifyUserOfPermissionRequestResult(isGranted);
	}

	public void grantedBy(SystemAdmin admin) {
		if (!state.equals(CLAIMED))
			return;
		if (!this.admin.equals(admin))
			return;
		state = GRANTED;
		isGranted = true;
		notifyUserOfPermissionRequestResult(isGranted);
	}

	private void notifyUserOfPermissionRequestResult(boolean result) {
		System.out.println(result?"通过授权":"未通过授权");
	}

	private void willBeHandledBy(SystemAdmin admin) {
		System.out.println("发起管理员授权！");
		this.admin = admin;
	}

	public String state() {
		return this.state;
	}

	public boolean isGranted() {
		return this.isGranted;
	}

}

package com.skycloud.refactor.state.latest;

public class ClaimedState extends PermissionState {

	public ClaimedState(String name) {
		super(name);
	}

	public void deniedBy(SystemAdmin admin,SystemPermission permission) {
		if (!permission.getAdmin().equals(admin))
			return;
		permission.setGranted(false);
		permission.setState(DENIED);
		notifyUserOfPermissionRequestResult(permission.isGranted());
	}

	public void grantedBy(SystemAdmin admin,SystemPermission permission) {
		if (!permission.getAdmin().equals(admin))
			return;
		permission.setState(GRANTED);
		permission.setGranted(true);
		notifyUserOfPermissionRequestResult(permission.isGranted());
	}
}

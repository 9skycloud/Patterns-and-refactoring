package com.skycloud.refactor.state.latest;

public class RequestedState extends PermissionState {

	public RequestedState(String name) {
		super(name);
	}
	
	public void claimedBy(SystemAdmin admin,SystemPermission permission) {
		willBeHandledBy(admin,permission);
		permission.setState(CLAIMED);
	}

}

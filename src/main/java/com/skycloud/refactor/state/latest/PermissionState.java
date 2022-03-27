package com.skycloud.refactor.state.latest;

public abstract class PermissionState {

	private String name;

	public PermissionState(String name) {
		this.name = name;
	}
	
	public final static PermissionState REQUESTED = new RequestedState("REQUESTED");
	public final static PermissionState CLAIMED = new ClaimedState("CLAIMED");
	public final static PermissionState GRANTED = new GrantedState("GRANTED");
	public final static PermissionState DENIED = new DeniedState("DENIED");
	public final static PermissionState UNIX_REQUEST = new UnitRequestedState("UNIX_REQUESTED");
	
	public void claimedBy(SystemAdmin admin,SystemPermission permission){
		
	};

	public void deniedBy(SystemAdmin admin,SystemPermission permission) {
	}

	public void grantedBy(SystemAdmin admin,SystemPermission permission) {
	}
	
	protected void notifyUserOfPermissionRequestResult(boolean result) {
		System.out.println(result?"通过授权":"未通过授权");
	}

	protected void willBeHandledBy(SystemAdmin admin,SystemPermission permission) {
		System.out.println("发起管理员授权！");
		permission.setAdmin(admin);
	}
}

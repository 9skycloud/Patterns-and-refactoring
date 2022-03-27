package com.skycloud.refactor.command.latest;

import java.util.HashMap;
import java.util.Map;

import com.skycloud.refactor.command.old.HandlerResponse;
import com.skycloud.refactor.command.old.WorkshopManager;


public class CatalogApp {

	static final String NEW_WORKSHOP = "NEW";
	static final String ALL_WORKSHOP = "ALL";
	WorkshopManager workshopManager = new WorkshopManager();
	
	private Map map = new HashMap();
	
	public CatalogApp() {
		initData();
	}

	public HandlerResponse executeActionAndGetResponse(String actionName,Map parameters){
		return lookupHandler(actionName).execute(parameters);
	}
	
	private void initData(){
		map.put(NEW_WORKSHOP, new NewCommandHandler(this));
		map.put(ALL_WORKSHOP, new AllCommandHandler(this));
	}
	
	private AbstractHandler lookupHandler(String actionName){
		return (AbstractHandler) map.get(actionName);
	}
	
	public WorkshopManager getWorkshopManager() {
		return workshopManager;
	}

	

}

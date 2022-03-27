package com.skycloud.refactor.command.latest;

import java.util.Map;

import com.skycloud.refactor.command.old.HandlerResponse;
import com.skycloud.refactor.command.old.WorkshopManager;

public abstract class AbstractHandler {

	protected CatalogApp catalogApp;

	public AbstractHandler(CatalogApp catalogApp) {
		this.catalogApp = catalogApp;
	}

	public CatalogApp getCatalogApp() {
		return catalogApp;
	}

	public void setCatalogApp(CatalogApp catalogApp) {
		this.catalogApp = catalogApp;
	}

	protected WorkshopManager getMgr() {
		return catalogApp.getWorkshopManager();
	}
	
	public abstract HandlerResponse execute(Map parameters);

}
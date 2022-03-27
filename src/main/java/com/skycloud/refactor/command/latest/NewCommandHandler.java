package com.skycloud.refactor.command.latest;

import java.util.Map;

import com.skycloud.refactor.command.old.HandlerResponse;

public class NewCommandHandler extends AbstractHandler {
	

	public NewCommandHandler(CatalogApp catalogApp) {
		super(catalogApp);
	}

	public HandlerResponse execute(Map parameters) {
		cacheNewData(getMgr().getNextWorkshopID());
		return catalogApp.executeActionAndGetResponse(catalogApp.ALL_WORKSHOP,parameters);
	}

	private void cacheNewData(String nextWorkshopID) {
		Map neworkshopContents = createHtmlFile(nextWorkshopID);
		getMgr().addWorkshop(neworkshopContents);
	}

	private Map createHtmlFile(String nextWorkshopID) {
		return getMgr().createNewFileFromTemplate(
				nextWorkshopID,
				getMgr().getWorkshopDir(),
				getMgr().getWorkshopTemplate()
				);
	}
	
}

package com.skycloud.refactor.command.latest;

import java.util.Iterator;
import java.util.Map;

import com.skycloud.refactor.command.old.HandlerResponse;
import com.skycloud.refactor.command.old.Workshop;
import com.skycloud.refactor.command.old.WorkshopRepository;
import com.skycloud.refactor.creative.builder.XmlBuilder;

public class AllCommandHandler extends AbstractHandler{
	
	public AllCommandHandler(CatalogApp catalogApp) {
		super(catalogApp);
	}

	public HandlerResponse execute(Map parameters) {
		return new HandlerResponse(new StringBuffer(findAllData()),catalogApp.ALL_WORKSHOP);
	}

	private String findAllData() {
		XmlBuilder allworkshopsXml = new XmlBuilder("workshops");
		WorkshopRepository repository = getMgr().getWorkshopRepository();
		Iterator ids = repository.keyIterator();
		while(ids.hasNext()){
			Workshop workshop = (Workshop) ids.next();
			allworkshopsXml.addToTarget("workshops","workshop");
			allworkshopsXml.addAttribute("id",workshop.getId());
			allworkshopsXml.addAttribute("name",workshop.getName());
			allworkshopsXml.addAttribute("status",workshop.getStatus());
			allworkshopsXml.addAttribute("duration",workshop.getDurationAsString());
		}
		return allworkshopsXml.printXml();
	}
	
}

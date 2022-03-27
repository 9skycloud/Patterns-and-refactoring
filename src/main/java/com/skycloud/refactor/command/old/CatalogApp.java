package com.skycloud.refactor.command.old;

import java.util.Iterator;
import java.util.Map;

import com.skycloud.refactor.creative.builder.XmlBuilder;


public class CatalogApp {

	private static final String NEW_WORKSHOP = "NEW";
	private static final String ALL_WORKSHOP = "ALL";
	WorkshopManager workshopManager = new WorkshopManager();

	public HandlerResponse executeActionAndGetResponse(String actionName,Map parameters){
		if(actionName.equals(NEW_WORKSHOP)){
			String nextWorkshopID = workshopManager.getNextWorkshopID();
			Map neworkshopContents = 
					workshopManager.createNewFileFromTemplate(
							nextWorkshopID,
							workshopManager.getWorkshopDir(),
							workshopManager.getWorkshopTemplate()
							);
			workshopManager.addWorkshop(neworkshopContents);
			parameters.put("id", nextWorkshopID);
			return executeActionAndGetResponse(ALL_WORKSHOP,parameters);
		}else if(actionName.equals(ALL_WORKSHOP)){
			XmlBuilder allworkshopsXml = new XmlBuilder("workshops");
			WorkshopRepository repository = workshopManager.getWorkshopRepository();
			Iterator ids = repository.keyIterator();
			while(ids.hasNext()){
//				String id = (String) ids.next();
				Workshop workshop = (Workshop) ids.next();
				allworkshopsXml.addToTarget("workshops","workshop");
				allworkshopsXml.addAttribute("id",workshop.getId());
				allworkshopsXml.addAttribute("name",workshop.getName());
				allworkshopsXml.addAttribute("status",workshop.getStatus());
				allworkshopsXml.addAttribute("duration",workshop.getDurationAsString());
			}
			String formattedXml = getFormattedData(allworkshopsXml.printXml());
			return new HandlerResponse(new StringBuffer(formattedXml),ALL_WORKSHOP);
		}
		/*
		 * 
		 * else if(){
			
		}else if(){
			
		}*/
		return null;
		
	}

	private String getFormattedData(String string) {
		return string;
	}
}

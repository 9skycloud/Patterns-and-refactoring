package com.skycloud.refactor.command;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.skycloud.refactor.command.old.CatalogApp;
import com.skycloud.refactor.command.old.HandlerResponse;

public class TestCommand {

	@Test
	public void testServerCommand(){
		CatalogApp app = new CatalogApp();
		Map<String,String> map = new HashMap<>();
		HandlerResponse response = app.executeActionAndGetResponse("NEW", map);
		System.out.println(response.getData());
		System.out.println(response.getKey());
	}
	
}

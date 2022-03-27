package com.skycloud.refactor.creative.factory.method.old;




public class XMLBuilderTest{
	
	private OutputBuilder builder;

	public void testAddAboveRoot(){
		String invalidResult = 
				"<orders>"+
						"<order>"+
						"</order>"+
				"</orders>"+
					"<customer>"+
				"</customer>";
		builder = new XMLBuilder("orders");
		builder.addBelow("order");
		try{
			builder.addAbove("customer");
		}catch(RuntimeException e){
			
		}
	}
}

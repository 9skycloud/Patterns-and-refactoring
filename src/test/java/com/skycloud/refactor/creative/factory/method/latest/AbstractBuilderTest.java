package com.skycloud.refactor.creative.factory.method.latest;

import junit.framework.TestCase;


/**
 * 用模板方式
 * @author QQ445161315
 *
 */
public abstract class AbstractBuilderTest extends TestCase{

	private OutputBuilder builder;
	
	public abstract OutputBuilder createBuilder(String rootName);
	
	public void testAddAboveRoot(){
		String invalidResult = 
				"<orders>"+
						"<order>"+
						"</order>"+
				"</orders>"+
					"<customer>"+
				"</customer>";
		builder = createBuilder("orders");
		builder.addBelow("order");
		try{
			builder.addAbove("customer");
		}catch(RuntimeException e){
			
		}
	}
	
}

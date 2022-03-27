package com.skycloud.refactor.command.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WorkshopManager {
	
	private static final String TEMPLATE_PATH = "src/main/resource/templates";
	
	private Map<String,Map> cache = new HashMap<String,Map>();
	
	private WorkshopRepository res = new WorkshopRepository();

	public String getNextWorkshopID() {
		try {
            TimeUnit.NANOSECONDS.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSSSSSS");
        return sdf.format(date);
	}

	public Object getWorkshopDir() {
		return TEMPLATE_PATH;
	}

	public String getWorkshopTemplate() {
		return "user.ftl";
	}

	public Map createNewFileFromTemplate(String nextWorkshopID,
			Object workshopDir, Object workshopTemplate) {
		StringBuffer result = new StringBuffer(); 
		Configuration configuration = new Configuration();
         Writer out = null;
         try {
             // step2 获取模版路径
             configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
             // step3 创建数据模型
             Map<String, Object> dataMap = new HashMap<String, Object>();
             dataMap.put("id", "1");
             dataMap.put("name", "zhangsan");
             dataMap.put("status", "1");
             dataMap.put("durationAsString", "test");
             // step4 加载模版文件
             Template template = configuration.getTemplate("user.ftl");
             // step5 生成数据
             File docFile = new File(TEMPLATE_PATH + "\\" + nextWorkshopID + ".html");
             out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
             // step6 输出文件
             template.process(dataMap, out);
//             result.append(dataMap);
             return dataMap;
//             cache.put(nextWorkshopID,dataMap);
//             System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^user.ftl 文件创建成功 !");
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 if (null != out) {
                     out.flush();
                 }
             } catch (Exception e2) {
                 e2.printStackTrace();
             }
         }
         return null;
	}

	public void addWorkshop(Map<String,String> neworkshopContents) {
		Workshop shop = new Workshop();
		shop.setId(neworkshopContents.get("id"));
		shop.setName(neworkshopContents.get("name"));
		shop.setStatus(neworkshopContents.get("status"));
		shop.setDurationAsString(neworkshopContents.get("durationAsString"));
		res.add(shop);
	}

	public WorkshopRepository getWorkshopRepository() {
		return res;
	}

}

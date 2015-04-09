package com.tc.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tc.entity.Product;
import com.tc.util.ExcelUtil;
import com.tc.util.XMLUtil;

public class ExcelTest {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
			List list = new ArrayList();			
			File parentFile=new File("e:/TP53");
		    if(parentFile.exists()){
		    	File[] nodeFile=parentFile.listFiles();
		    	for(int i=0;i<nodeFile.length;i++){
		    		File file = nodeFile[i];
		    		String fileNamePath = file.toString();
		    		
		    		//截取数据Id
		    		int start = fileNamePath.lastIndexOf("\\")+1;
		    		int end = fileNamePath.indexOf(".");
		    		String id = fileNamePath.substring(start, end);
		    		
		    		//XML生成实体类对象
		    		Product product = XMLUtil.gitExcel(fileNamePath,id);   //传入一个文件名，得到一个product对象
		    		list.add(product);
		    	}		    	
		    }
		    
		    ExcelUtil.getExcel(list);  //调用Excel导出，文件生成到E盘根目录
		    System.out.println("========成功！！！！==========");
	
	}
}

package com.tc.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tc.entity.Product;

public class XMLUtil {

	public static Product gitExcel(String FileNamePath,String id) throws SAXException, IOException, ParserConfigurationException{
		
		Product product = new Product();
		
		// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	      
	    // step 2:获得具体的dom解析器  
	    DocumentBuilder db = dbf.newDocumentBuilder();  
	      
	    // step3: 解析一个xml文档，获得Document对象（根结点）  
	    Document document = db.parse(new File(FileNamePath));   //给文件名路径
	    
	    product.setId(id);
	    
	    //得到condition节点
	    NodeList conditionList = document.getElementsByTagName("condition");  
	    String bb = conditionList.item(0).getFirstChild().getNodeValue();
	    product.setCondition(bb);
	    
	    ////得到city节点
	    String cityValue2="";
	    NodeList cityList = document.getElementsByTagName("address");
	    for(int k1=0;k1<cityList.getLength();k1++){
	    	Element cityElement = (Element)cityList.item(k1);
	    	String cityValue = cityElement.getElementsByTagName("city").item(0).getFirstChild().getNodeValue(); 
	    	cityValue2 = cityValue2+cityValue+"|";
	    }
	    product.setCity(cityValue2);
	    
//	    //得到location_countries节点
//        NodeList counList = document.getElementsByTagName("location_countries"); 
//	    
//        for(int k2=0;k2<counList.getLength();k2++){
//        	
//        	Element counElement = (Element)counList.item(k2); 
//        	
//        	
//        	String conte0 = counElement.getElementsByTagName("country").item(0).getFirstChild().getNodeValue();
//        	String conte1 = counElement.getElementsByTagName("country").item(1).getFirstChild().getNodeValue();
//        	
//        	System.out.println("3==="+conte0+"|"+conte1);
//        	
//        }
	    
	    
//	    //得到location_countries节点
	      NodeList counList = document.getElementsByTagName("location_countries"); 
		  String conte2="";  
	      for(int k2=0;k2<counList.getLength();k2++){
	      	
	      	Element counElement = (Element)counList.item(k2); 
	      	
	      	NodeList hList = counElement.getElementsByTagName("country");
	      	for(int h=0;h<hList.getLength();h++){
	      		String conte0 = counElement.getElementsByTagName("country").item(h).getFirstChild().getNodeValue();
	      		conte2 = conte2 + conte0 + "|";	      	
	      	}
	      }
	      product.setLocation_countries(conte2);
	    
        
        //得到overall_status节点
        NodeList phaseList = document.getElementsByTagName("phase");  
        String phaseValue = phaseList.item(0).getFirstChild().getNodeValue();
        product.setOverall_status(phaseValue);
	    
        //得到phase节点
        NodeList overList = document.getElementsByTagName("overall_status");  
        String overValue = overList.item(0).getFirstChild().getNodeValue();
        product.setPhase(overValue);
        
      //得到gender节点
        NodeList eligList = document.getElementsByTagName("eligibility");
        for(int k4=0;k4<eligList.getLength();k4++){
        	
        	Element eligElement = (Element)eligList.item(k4);
        	
        	String genderValue = eligElement.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue(); 
        	product.setGender(genderValue);
        	
        }
        
      //得到criteria节点
        NodeList criList = document.getElementsByTagName("criteria");
        for(int k5=0;k5<criList.getLength();k5++){
        	Element criElement = (Element)criList.item(k5);
        	String textValue = criElement.getElementsByTagName("textblock").item(0).getFirstChild().getNodeValue(); 
        	product.setCriteria(textValue);
        }
        
        return product;
	}
	
}

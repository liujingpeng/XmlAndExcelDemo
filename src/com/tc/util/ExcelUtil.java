package com.tc.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.tc.entity.Product;

public class ExcelUtil {

	//生成Excel文件
	public static void getExcel(List<Product> list){
					//1-1创建工作簿
					HSSFWorkbook wb=new HSSFWorkbook();
					//1-2根据工作簿创建工作表格
					HSSFSheet sheet=wb.createSheet("信息表");
					//添加一行表头
					HSSFRow rowtitle=sheet.createRow(0);
					/**
						  private String id ; 				//基因ID
						  private String condition;			//片段1
						  private String city;  			//片段2
						  private String location_countries;  //片段3
						  private String overall_status;	//片段4
						  private String phase;				//片段5
						  private String gender;			//片段6
						  private String criteria;			//片段7
					 */
					HSSFCell idTitleCell=rowtitle.createCell(0);
					idTitleCell.setCellValue("id");
					HSSFCell materialidCell=rowtitle.createCell(1);
					materialidCell.setCellValue("片段1-condition");
					HSSFCell typeidTitleCell=rowtitle.createCell(2);
					typeidTitleCell.setCellValue("片段2-city");
					HSSFCell nameTitleCell=rowtitle.createCell(3);
					nameTitleCell.setCellValue("片段3-location_countries");
					
					HSSFCell statusCell=rowtitle.createCell(4);
					statusCell.setCellValue("片段4-overall_status");
					
					HSSFCell guanlimanCell=rowtitle.createCell(5);
					guanlimanCell.setCellValue("片段5-phase");
					
					HSSFCell measureCell=rowtitle.createCell(6);
					measureCell.setCellValue("片段6-gender");
					
					HSSFCell shuliangCell=rowtitle.createCell(7);
					shuliangCell.setCellValue("片段7-criteria");
					
					
					//2:将数据填入Excel表的每行每列中
					
					for(int i=0;i<list.size();i++){
						Product p = list.get(i);
						
						//创建行
						HSSFRow rows=sheet.createRow(i+1);
						//根据行创建列
						
						//将数据填充到每列中
						//基因Id
						HSSFCell idCell=rows.createCell(0);
						idCell.setCellValue(p.getId());
						//片段1
						HSSFCell materialid=rows.createCell(1);
						materialid.setCellValue(p.getCondition());
						//片段2
						HSSFCell typeid=rows.createCell(2);
						typeid.setCellValue(p.getCity());
						//片段3
						HSSFCell name=rows.createCell(3);
						name.setCellValue(p.getLocation_countries());
						//片段4
						HSSFCell status=rows.createCell(4);
						status.setCellValue(p.getOverall_status());
						//片段5
						HSSFCell guanliman=rows.createCell(5);
						guanliman.setCellValue(p.getPhase());
						//片段6
						HSSFCell measure=rows.createCell(6);
						measure.setCellValue(p.getGender());
						//片段7
						HSSFCell shuliang=rows.createCell(7);
						shuliang.setCellValue(p.getCriteria());
						
						
					}
				//3:使用IO流将内存中的Excel写入磁盘中
				try {
					FileOutputStream fout=new FileOutputStream("e:\\DB.xls");
					//使用流将工作簿对象写出到磁盘
					wb.write(fout);
					fout.close();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 *
 * @author Wenqing
 */
public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook wb, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = wb.createSheet("Sales Order Sheet");
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("rownum");
        header.createCell(1).setCellValue("SalesOrderID");
	header.createCell(2).setCellValue("RevisionNumber");
        header.createCell(3).setCellValue("OrderDate");
        header.createCell(4).setCellValue("DueDate");
        header.createCell(5).setCellValue("ShipDate");
        header.createCell(6).setCellValue("Status");
        header.createCell(7).setCellValue("OnlineOrderFlag");
        header.createCell(8).setCellValue("SalesOrderNumber");
        header.createCell(9).setCellValue("PurchaseOrderNumber");
        header.createCell(10).setCellValue("AccountNumber");
        header.createCell(11).setCellValue("CustomerID");
        header.createCell(12).setCellValue("SalesPersonID");
        header.createCell(13).setCellValue("TerritoryID");
        header.createCell(14).setCellValue("BillToAddressID");
        header.createCell(15).setCellValue("ShipToAddressID");
        header.createCell(16).setCellValue("ShipMethodID");
        header.createCell(17).setCellValue("CreditCardID");
        header.createCell(18).setCellValue("CreditCardApprovalCode");
        header.createCell(19).setCellValue("CurrencyRateID");
        header.createCell(20).setCellValue("SubTotal");
        header.createCell(21).setCellValue("TaxAmt");
        header.createCell(22).setCellValue("Freight");
        header.createCell(23).setCellValue("TotalDue");
        header.createCell(24).setCellValue("Comment");
        header.createCell(25).setCellValue("ModifiedDate");
        
        HttpSession session = request.getSession(true);
        Map<String, ArrayList<String>> hashmap = (HashMap) session.getAttribute("jspdata");
        int numrow = 1;
		for (Map.Entry<String,ArrayList<String>> entry : hashmap.entrySet()){
                    HSSFRow row = sheet.createRow(numrow);
		    row.createCell(0).setCellValue(entry.getKey());
                    ArrayList<String> rowstring = entry.getValue();
                    int numcell = 1;
                    for(String s: rowstring){
                        row.createCell(numcell).setCellValue(s);
                        numcell++;
                    }
                    numrow++;
                }                
    }    
}
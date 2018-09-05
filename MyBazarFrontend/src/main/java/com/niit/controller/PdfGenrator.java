package com.niit.controller;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.niit.model.CartItem;

public class PdfGenrator 
{


public static void createPdf(List<CartItem> cartItems, String username,int totalPurchaseAmount) {
	 Document document = new Document(PageSize.A4);
     document.addAuthor("Abhishek");
     document.addTitle("Demo for Itext");
     
     
     System.out.println("document created....");
    try
    {
 	PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ASUS\\workspace\\MyBazarFrontend\\src\\main\\webapp\\resources\\recipt\\"+username+".pdf"));
 	System.out.println("writer instance created....");
	        document.open();
	        System.out.println("document open....");
	        for(CartItem ob:cartItems){
	        	System.out.println("document open....");
	        Paragraph para=new Paragraph(ob.getCartItemId()+"\n"+ob.getProductName()+"\n"+ob.getPrice()+"\n"+ob.getQuantity()+"\n"+ob.getUsername());
	        para.setPaddingTop(12);
	       
	        document.add(para);
	        }
	        System.out.println("para added to document....");
	       
    }
 catch (Exception e) 
    {
	 e.printStackTrace();
 	 System.out.println("e");
	}
     document.close();
     System.out.println("document closed....");
}
	
}



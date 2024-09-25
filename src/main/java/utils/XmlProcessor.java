package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import models.Staff;

public class XmlProcessor{
	
	
	private static Staff parseNodeList(Node nodoActual) { // RECIBE UN NODO, EN ESTE CASO EL STAFF(NODO COMPLETO)
		
		Staff objStaff = null;

		if (nodoActual.getNodeType() == Node.ELEMENT_NODE) {

			Element staffNode = (Element) nodoActual;
			
			String firstName = staffNode.getElementsByTagName("firstName").item(0).getTextContent();
			String lastName = staffNode.getElementsByTagName("lastName").item(0).getTextContent();
			String nickName = staffNode.getElementsByTagName("nickName").item(0).getTextContent();
			int salary = Integer.parseInt(staffNode.getElementsByTagName("salary").item(0).getTextContent()); 
			
			Node nodeSalary = staffNode.getElementsByTagName("salary").item(0);
			
			if (nodeSalary.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eNodeSalary = (Element) nodeSalary;
				
				String currency = eNodeSalary.getAttribute("currency");
				
				objStaff = new Staff(firstName,lastName,nickName,salary,currency);
				
				
				
			}
			
			
		}
		

		
		return objStaff;
		
	}
	
	
	public ArrayList<String> parseXML(){
		
		ArrayList<String> listaStringObj = new ArrayList<>();
		
		File file = new File("src/main/resources/file.xml");
		
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			NodeList listaNodosStaff = doc.getElementsByTagName("staff");
			
			System.out.println(listaNodosStaff.getLength());
			
			for (int i = 0; i < listaNodosStaff.getLength(); i++) {
				
				Node nodenew = listaNodosStaff.item(i);
				
				Staff stf = parseNodeList(nodenew);
				
				listaStringObj.add(stf.toString());

			}			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return listaStringObj;
		
		
	}
	
	
	
	
	
}

package xml_procesamiento.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ch.qos.logback.core.pattern.parser.Node;

@SpringBootApplication
public class XmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlApplication.class, args);
		
		
		File file = new File("src/main/resources/file.xml");
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			
			NodeList nList = doc.getElementsByTagName("staff");
			
			
			System.out.println(nList.getLength());
			
			
			org.w3c.dom.Node nodoactual = nList.item(0);
			
			System.out.println(nodoactual);
			
			 if (nodoactual.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				 
				 Element eElement = (Element) nodoactual;
				 
				 System.out.println(eElement.getAttribute("id"));
				 System.out.println(eElement.getElementsByTagName("firstname").item(0).getTextContent());
				 System.out.println(eElement.getElementsByTagName("lastname").item(0).getTextContent());
				 System.out.println(eElement.getElementsByTagName("salary").item(0).getTextContent());
				 
				 
				 
				 
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
		
		
		
		
		
		
	}

}

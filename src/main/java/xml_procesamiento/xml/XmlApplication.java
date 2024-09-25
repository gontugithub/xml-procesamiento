package xml_procesamiento.xml;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import utils.XmlProcessor;

@SpringBootApplication
public class XmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlApplication.class, args);
		
		XmlProcessor xml = new XmlProcessor();
		
		try {
			
			PrintWriter salidaTxt = new PrintWriter(new FileWriter("src/main/resources/salida.txt"));
			
			ArrayList<String> listaObjStaff = xml.parseXML();
			
			for (String staff : listaObjStaff) {
				salidaTxt.println(staff);
			}
			
			salidaTxt.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}

package javasmmr.zoowsome.repositories;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLEventFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLEventFactory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
//import javax.xml.stream.events.StartElement;
//import javax.xml.stream.events.XMLEvent;

import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.models.employees.CareTaker;
import javasmmr.zoowsome.models.employees.Employee;
//import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.utils.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class EmployeesRepository extends EntityRepository<Employee> {
	private static final String XML_FILENAME = "Employees.xml";
	Scanner s = new Scanner(System.in);

	public EmployeesRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.EMPLOYEES);
	}

	public ArrayList<Employee> load() throws ParserConfigurationException, SAXException, IOException {

		ArrayList<Employee> employees = new ArrayList<Employee>();

		File fXmlFile = new File(XML_FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName(Constants.XML_TAGS.EMPLOYEES);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
						.getTextContent();
				switch (discriminant) {
				case Constants.Employee.CareTaker:
					System.out.println("Enter employee's name: ");
					String name = s.next();
					System.out.println("Enter employee's id: ");
					long id = s.nextLong();
					System.out.println("Enter employee's salary: ");
					BigDecimal salary = s.nextBigDecimal();
					System.out.println("Enter employee's working hours: ");
					double workingHours = s.nextDouble();
					CareTaker careTaker = new CareTaker(name, id, salary, workingHours);
					careTaker.decodeFromXml(element);
					employees.add(careTaker);
					break;
				default:
					break;
				}
			}
		}
		return employees;
	}

	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);

		eventWriter.add(characters); // Create End node

		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}
	

}
package javasmmr.zoowsome.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLEventFactory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
//import javax.xml.stream.events.StartElement;
//import javax.xml.stream.events.XMLEvent;

import javasmmr.zoowsome.models.animals.*;
//import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.utils.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class AnimalRepository extends EntityRepository<Animal> {
	private static final String XML_FILENAME = "Animals.xml";

	public AnimalRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);
	}

	public ArrayList<Animal> load() throws ParserConfigurationException, SAXException, IOException {

		ArrayList<Animal> animals = new ArrayList<Animal>();

		File fXmlFile = new File(XML_FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName(Constants.XML_TAGS.ANIMAL);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
						.getTextContent();
				switch (discriminant) {
				case Constants.Animals.Insects.Butterfly:
					Animal butterfly = new Butterfly();
					butterfly.decodeFromXml(element);
					animals.add(butterfly);
					break;
				case Constants.Animals.Insects.Dragonfly:
					Animal dragonfly = new Dragonfly();
					dragonfly.decodeFromXml(element);
					animals.add(dragonfly);
					break;
				case Constants.Animals.Insects.Spider:
					Animal spider = new Spider();
					spider.decodeFromXml(element);
					animals.add(spider);
					break;
				case Constants.Animals.Aquatics.Shark:
					Animal shark = new Shark();
					shark.decodeFromXml(element);
					animals.add(shark);
					break;
				case Constants.Animals.Aquatics.Clownfish:
					Animal clownfish = new Clownfish();
					clownfish.decodeFromXml(element);
					animals.add(clownfish);
					break;
				case Constants.Animals.Aquatics.Piranha:
					Animal piranha = new Piranha();
					piranha.decodeFromXml(element);
					animals.add(piranha);
					break;
				case Constants.Animals.Mammals.Donkey:
					Animal donkey = new Donkey();
					donkey.decodeFromXml(element);
					animals.add(donkey);
					break;
				case Constants.Animals.Mammals.Lion:
					Animal lion = new Lion();
					lion.decodeFromXml(element);
					animals.add(lion);
					break;
				case Constants.Animals.Mammals.Bear:
					Animal bear = new Bear();
					bear.decodeFromXml(element);
					animals.add(bear);
					break;
				case Constants.Animals.Birds.Parrot:
					Animal parrot = new Parrot();
					parrot.decodeFromXml(element);
					animals.add(parrot);
					break;
				case Constants.Animals.Birds.Hummingbird:
					Animal hummingbird = new Hummingbird();
					hummingbird.decodeFromXml(element);
					animals.add(hummingbird);
					break;
				case Constants.Animals.Birds.Penguin:
					Animal penguin = new Penguin();
					penguin.decodeFromXml(element);
					animals.add(penguin);
					break;
				case Constants.Animals.Reptiles.Alligator:
					Animal alligator = new Alligator();
					alligator.decodeFromXml(element);
					animals.add(alligator);
					break;
				case Constants.Animals.Reptiles.Snake:
					Animal snake = new Snake();
					snake.decodeFromXml(element);
					animals.add(snake);
					break;
				case Constants.Animals.Reptiles.Lizzard:
					Animal lizzard = new Lizzard();
					lizzard.decodeFromXml(element);
					animals.add(lizzard);
					break;
				default:
					break;
				}
			}
		}
		return animals;
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
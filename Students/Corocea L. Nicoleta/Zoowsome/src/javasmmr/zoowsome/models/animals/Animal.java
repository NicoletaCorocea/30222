package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
//import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;

import org.w3c.dom.Element;

public abstract class Animal implements Killer_i, XML_Parsable {
	private int nrOfLegs;
	private String name;
	final double maintenanceCost;
	final double dangPerc;
	boolean takenCareOf = false;

	public Animal(double maintenanceCost2, double dangPerc2) {
		// TODO Auto-generated constructor stub
		this.maintenanceCost = maintenanceCost2;
		this.dangPerc = dangPerc2;
	}

	public int getNrOfLegs() {
		return nrOfLegs;
	}

	public void setNrOfLegs(int nrOfLegs) {
		this.nrOfLegs = nrOfLegs;
	}

	public String getString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean kill() {
		Random random = new Random();
		double randomValue = random.nextDouble();
		if (randomValue < this.dangPerc) {
			return true;
		}
		return false;

	}

	public void SetTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}

	public boolean getTakenCareOf() {
		return takenCareOf;
	}

	public double getMaintenanceCost() {
		// TODO Auto-generated method stub
		return this.maintenanceCost;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
		createNode(eventWriter, "dangerPerc", String.valueOf(this.dangPerc));
		createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}

	public void decodeFromXml(Element element) {
		setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setMaintenanceCost(Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent()));
		setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
	}

	private void setDangerPerc(Double valueOf) {
		// TODO Auto-generated method stub

	}

	private void setMaintenanceCost(Double valueOf) {
		// TODO Auto-generated method stub

	}
}

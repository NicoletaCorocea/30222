package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Mammal extends Animal {
	float normalBodyTemp;
	float percBodyHair;

	public Mammal(double maintenanceCost, double dangPerc, float normalBodyTemp, float percBodyHair) {
		super(maintenanceCost, dangPerc);
		this.normalBodyTemp = normalBodyTemp;
		this.percBodyHair = percBodyHair;
		// TODO Auto-generated constructor stub
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "normalBodyTemp", String.valueOf(getNormalBodyTemp()));
		createNode(eventWriter, "percBodyHair", String.valueOf(getPercBodyHair()));
	}

	private float getPercBodyHair() {
		// TODO Auto-generated method stub
		return this.percBodyHair;
	}

	private float getNormalBodyTemp() {
		// TODO Auto-generated method stub
		return this.normalBodyTemp;
	}

	public void decodeFromXml(Element element) {
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("normalBodyTemp").item(0).getTextContent()));
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("percBodyHair").item(0).getTextContent()));
	}

}

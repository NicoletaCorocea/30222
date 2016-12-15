package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Bird extends Animal {
	boolean migrates;
	int avgFlightAltitude;

	public Bird(double maintenanceCost, double dangPerc, boolean migrates, int avgFlightAltitude) {
		super(maintenanceCost, dangPerc);
		this.avgFlightAltitude = avgFlightAltitude;
		this.migrates = migrates;
		// TODO Auto-generated constructor stub
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "migrates", String.valueOf(getMigrates()));
		createNode(eventWriter, "avgFlightAltitude", String.valueOf(getAvgFlightAltitude()));
	}

	private int getAvgFlightAltitude() {
		// TODO Auto-generated method stub
		return this.avgFlightAltitude;
	}

	private boolean getMigrates() {
		// TODO Auto-generated method stub
		return this.migrates;
	}

	public void decodeFromXml(Element element) {
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
	}

}

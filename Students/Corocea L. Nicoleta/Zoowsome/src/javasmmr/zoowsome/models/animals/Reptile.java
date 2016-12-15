package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
//import javasmmr.zoowsome.repositories.AnimalRepository;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Reptile extends Animal {
	boolean laysEggs;

	public Reptile(double maintenanceCost, double dangPerc, boolean laysEggs) {
		super(maintenanceCost, dangPerc);
		this.laysEggs = laysEggs;
		// TODO Auto-generated constructor stub
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "laysEggs", String.valueOf(getLaysEggs()));

	}

	private boolean getLaysEggs() {
		// TODO Auto-generated method stub
		return this.laysEggs;
	}

	public void decodeFromXml(Element element) {
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("laysEggs").item(0).getTextContent()));

	}

}

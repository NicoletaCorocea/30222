package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Alligator extends Reptile {
	public Alligator(int nrOfLegs, String name, boolean laysEggs, double maintenanceCost, double dangPerc) {
		super(maintenanceCost, dangPerc, laysEggs);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Alligator() {
		super(3, 0.9, true);
		this.setName("Alligator");
		this.setNrOfLegs(4);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Alligator);
	}
}

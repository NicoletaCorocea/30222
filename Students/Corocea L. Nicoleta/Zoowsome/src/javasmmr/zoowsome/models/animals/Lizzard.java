package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Lizzard extends Reptile {
	public Lizzard(int nrOfLegs, String name, boolean laysEggs, double maintenanceCost, double dangPerc) {
		super(maintenanceCost, dangPerc, laysEggs);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Lizzard() {
		super(1.5, 0.1, true);
		this.setName("Lizzard");
		this.setNrOfLegs(4);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Lizzard);
	}
}

package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Shark extends Aquatic {
	public Shark(int nrOfLegs, String name, int avgSwimDepth, Enum waterType, double maintenanceCost, double dangPerc) {
		super(maintenanceCost, dangPerc, avgSwimDepth, waterType);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Shark() {
		super(5, 1, 20, Enum.Saltwater);
		this.setName("Shark");
		this.setNrOfLegs(0);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.Shark);
	}
}

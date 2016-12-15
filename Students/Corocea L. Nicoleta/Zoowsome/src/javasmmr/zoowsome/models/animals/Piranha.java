package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Piranha extends Aquatic {
	public Piranha(int nrOfLegs, String name, int avgSwimDepth, Enum waterType, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, avgSwimDepth, waterType);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Piranha() {
		super(3, 0.8, 10, Enum.Freshwater);
		this.setName("Piranha");
		this.setNrOfLegs(0);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Butterfly);
	}
}

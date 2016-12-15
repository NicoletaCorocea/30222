package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Clownfish extends Aquatic {
	public Clownfish(int nrOfLegs, String name, int avgSwimDepth, Enum waterType, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, avgSwimDepth, waterType);
		this.setName(name);
		// this.avgSwimDepth = avgSwimDepth;
		this.setNrOfLegs(nrOfLegs);
		// this.waterType = waterType;

	}

	public Clownfish() {
		super(2, 0, 20, Enum.Saltwater);
		this.setName("Nemo");
		this.setNrOfLegs(0);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.Clownfish);
	}
}

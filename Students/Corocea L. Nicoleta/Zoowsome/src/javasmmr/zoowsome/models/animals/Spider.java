package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Spider extends Insect {
	public Spider(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, canFly, isDangerous);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Spider() {
		super(1, 0.6, false, true);
		this.setName("Spider");
		this.setNrOfLegs(8);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Spider);
	}
}

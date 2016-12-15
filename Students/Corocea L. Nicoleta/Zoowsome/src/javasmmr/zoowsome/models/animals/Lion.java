package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Lion extends Mammal {
	public Lion(int nrOfLegs, String name, float normalBodyTemp, float percBodyHair, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, percBodyHair, normalBodyTemp);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);
	}

	public Lion() {
		super(5, 1, 98, 40);
		this.setName("Simba");
		this.setNrOfLegs(4);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Lion);
	}
}

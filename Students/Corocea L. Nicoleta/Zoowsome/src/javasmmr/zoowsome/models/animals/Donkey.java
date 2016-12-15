package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Donkey extends Mammal {
	public Donkey(int nrOfLegs, String name, float normalBodyTemp, float percBodyHair, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, percBodyHair, normalBodyTemp);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);
	}

	public Donkey() {
		super(3, 0.1, 98, 40);
		this.setName("Donkey");
		this.setNrOfLegs(4);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Donkey);
	}
}

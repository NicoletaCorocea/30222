package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Bear extends Mammal {
	public Bear(int nrOfLegs, String name, float normalBodyTemp, float percBodyHair, double maintenanceCost,
			double dangPerc) {
		super(maintenanceCost, dangPerc, percBodyHair, normalBodyTemp);
		this.setNrOfLegs(nrOfLegs);
	}

	public Bear() {
		super(4, 0.9, 96, 35);
		this.setName("Yoghi");
		this.setNrOfLegs(4);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Bear);
	}
}

package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.utils.Constants;

public class Penguin extends Bird {
	public Penguin(String name, int nrOfLegs, double maintenanceCost, double dangPerc, boolean migrates,
			int avgFlightAltitude) {
		super(maintenanceCost, dangPerc, migrates, avgFlightAltitude);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);

	}

	public Penguin() {
		super(5, 0, false, 0);
		this.setName("Pingu");
		this.setNrOfLegs(2);

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.Penguin);
	}
}

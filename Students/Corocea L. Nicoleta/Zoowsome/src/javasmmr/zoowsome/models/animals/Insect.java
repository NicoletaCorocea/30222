package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Insect extends Animal {
	boolean canFly;
	boolean isDangerous;

	public Insect(double maintenanceCost, double dangPerc, boolean canFLy, boolean isDangerous) {
		super(maintenanceCost, dangPerc);
		this.canFly = canFLy;
		this.isDangerous = isDangerous;
	}

	public boolean getCanFly() {
		return this.canFly;
	}

	public boolean getIsDangerous() {
		return this.isDangerous;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "canFly", String.valueOf(getCanFly()));
		createNode(eventWriter, "isDangerous", String.valueOf(getIsDangerous()));
	}

	public void decodeFromXml(Element element) {
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
	}
}

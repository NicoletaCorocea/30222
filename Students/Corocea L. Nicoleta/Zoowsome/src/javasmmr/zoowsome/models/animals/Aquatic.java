package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

public abstract class Aquatic extends Animal {

	int avgSwimDepth;
	Enum waterType;

	public Aquatic(double maintenanceCost, double dangPerc, int avgSwimDepth, Enum waterType) {
		super(maintenanceCost, dangPerc);
		this.avgSwimDepth = avgSwimDepth;
		this.waterType = waterType;
		// TODO Auto-generated constructor stub
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth()));
		createNode(eventWriter, "waterType", String.valueOf(getWaterType()));
	}

	private Enum getWaterType() {
		// TODO Auto-generated method stub
		return this.waterType;
	}

	private int getAvgSwimDepth() {
		// TODO Auto-generated method stub
		return this.avgSwimDepth;
	}

	public void decodeFromXml(Element element) {
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
		SetTakenCareOf(Boolean.valueOf(element.getElementsByTagName("waterType").item(0).getTextContent()));
	}

}

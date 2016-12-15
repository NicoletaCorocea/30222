package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.utils.Constants;

public class CareTaker extends Employee implements CareTaker_I {
	double workingHours;

	public CareTaker(String name, long id, BigDecimal salary, double workingHours) {
		super(name, id, salary);
		// TODO Auto-generated constructor stub
		this.workingHours = workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	@Override
	public String takeCareOf(Animal animal) {
		if (animal.kill()) {
			return Constants.Employees.Caretakers.TCO_KILLED;
		}

		if (this.workingHours < animal.getMaintenanceCost()) {
			return Constants.Employees.Caretakers.TCO_NO_TIME;
		}
		animal.SetTakenCareOf(true);
		setWorkingHours(workingHours - animal.getMaintenanceCost());

		return Constants.Employees.Caretakers.TCO_SUCCESS;

	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "canFly", String.valueOf(getWorkingHours()));
	}

	@Override
	public void decodeFromXml(Element element) {
		setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
	}
}

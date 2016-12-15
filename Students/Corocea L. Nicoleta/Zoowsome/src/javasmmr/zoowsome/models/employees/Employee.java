package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;

public abstract class Employee implements XML_Parsable {
	String name;
	long id;
	BigDecimal salary;
	boolean isDead;

	public Employee(String name, long id, BigDecimal salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.isDead = false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "id", String.valueOf(this.id));
		createNode(eventWriter, "salary", String.valueOf(this.salary));
		createNode(eventWriter, "isDead", String.valueOf(this.isDead));
	}

	public void decodeFromXml(Element element) {
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setId(Long.valueOf(element.getElementsByTagName("id").item(0).getTextContent()));
		setSalary(BigDecimal.valueOf(element.getElementsByTagName("salary").item(0).getTextContent()));
		setIsDead(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
	}
}

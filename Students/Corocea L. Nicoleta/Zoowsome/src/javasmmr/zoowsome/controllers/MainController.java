package javasmmr.zoowsome.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.employees.CareTaker;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.repositories.EmployeesRepository;
import javasmmr.zoowsome.services.factories.animalFactory.AnimalFactory;
import javasmmr.zoowsome.services.factories.animalFactory.SpeciesFactory;
import javasmmr.zoowsome.services.factories.employeeFactory.EmployeeAbstractFactory;
import javasmmr.zoowsome.services.factories.employeeFactory.EmployeeFactory;
import javasmmr.zoowsome.utils.Constants;

public class MainController {
	public static void main(String[] args)
			throws XMLStreamException, ParserConfigurationException, SAXException, IOException {
		Scanner s = new Scanner(System.in);
		String result = null;

		EmployeeFactory empFact = new EmployeeFactory();
		EmployeeAbstractFactory empAbsFact = empFact.getEmployeeAbstractFactory(Constants.Employee.CareTaker);
		Employee e1 = empAbsFact.getEmployeeFactory(Constants.Employee.CareTaker);

		System.out.println("Insert the number of careTakers ");
		int n = s.nextInt();
		CareTaker[] c = new CareTaker[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Insert the name ");
			String name = s.next();
			System.out.println("Insert id ");
			long id = s.nextLong();
			System.out.println("Insert salary ");
			BigDecimal salary = s.nextBigDecimal();
			System.out.println("Insert working hours ");
			double workingHours = s.nextDouble();

			c[i] = new CareTaker(name, id, salary, workingHours);
		}

		AnimalFactory abstractFactory = new AnimalFactory();
		SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
		SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
		SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
		SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
		System.out.println("Insert the number of animals ");
		int m = s.nextInt();
		Animal[] a = new Animal[m];
		for (int j = 0; j < m; j++) {
			System.out.println("Which animal do you want to create?"
					+ "1-Bear\n2-Lion\n3-Donkey\n4-Shark\n5-Piranha\n6-Clownfish\n7-Butterfly\n8-Spider\n9-Dragonfly\n10-Lizzard\n11-Snake\n12-Alligator\n13-Parrot\n14-Penguin\n15-Hummingbird");
			int opt = s.nextInt();
			switch (opt) {
			case 1:
				a[j] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Bear);
				System.out.println("New bear was created.");
				break;
			case 2:
				a[j] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Lion);
				System.out.println("New lion was created.");
				break;
			case 3:
				a[j] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Donkey);
				System.out.println("New donkey was created.");
				break;
			case 4:
				a[j] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Shark);
				System.out.println("New shark was created.");
				break;
			case 5:
				a[j] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Piranha);
				System.out.println("New Piranha was created.");
				break;
			case 6:
				a[j] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Clownfish);
				System.out.println("New clownfish was created.");
				break;
			case 7:
				a[j] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Butterfly);
				System.out.println("New butterfly was created.");
				break;
			case 8:
				a[j] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Spider);
				System.out.println("New spider was created.");
				break;
			case 9:
				a[j] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Dragonfly);
				System.out.println("New dragonfly was created.");
				break;
			case 10:
				a[j] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Lizzard);
				System.out.println("New lizzard was created.");

				break;
			case 11:
				a[j] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Snake);
				System.out.println("New snake was created.");
				break;
			case 12:
				a[j] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Alligator);
				System.out.println("New alligator was created.");
				break;
			case 13:
				a[j] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Parrot);
				System.out.println("New parrot was created.");
				break;
			case 14:
				a[j] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Penguin);
				System.out.println("New penguin was created.");
				break;
			case 15:
				a[j] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Hummingbird);
				System.out.println("New hummingbird was created.");
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((c[i].getIsDead() == false) && a[j].getTakenCareOf() == false) {
					result = c[i].takeCareOf(a[j]);

					if (result.equals(Constants.Employees.Caretakers.TCO_KILLED)) {
						c[i].setIsDead(true);
						System.out.println("Caretaker " + i + " killed by " + a[j].getString());
					} else if (result.equals(Constants.Employees.Caretakers.TCO_NO_TIME)) {
						System.out.println("Caretaker " + i + " has no time for " + a[j].getString());
					} else {
						a[j].SetTakenCareOf(true);
						System.out.println("Caretaker " + i + " took care of " + a[j].getString());
					}
				}
			}
		}
		s.close();

		AnimalRepository animalRepository = new AnimalRepository();
		ArrayList<Animal> animals = new ArrayList<Animal>();

		for (int i = 0; i < m; i++) {
			animals.add(a[i]);
		}

		animalRepository.save(animals);
		System.out.println("hey");
		animals = animalRepository.load();

		System.out.println("My xml: ");
		for (int i = 0; i < m; i++) {
			System.out.println(animals.get(i).getString());
		}

		EmployeesRepository employeeRepository = new EmployeesRepository();
		ArrayList<Employee> employees = new ArrayList<Employee>();

		for (int i = 0; i < m; i++) {
			employees.add(c[i]);
		}

		employeeRepository.save(employees);
		System.out.println("hey");
		employees = employeeRepository.load();

		System.out.println("My xml: ");
		for (int i = 0; i < m; i++) {
			System.out.println(((Employee) employees.get(i)).getName());
		}
	}

}

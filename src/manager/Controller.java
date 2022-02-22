package manager;

import dao.Reader;
import exceptions.ExecutionException;
import exceptions.LogicException;
import model.Buildings;
import model.City;
import model.Edifice;
import model.Person;
import utils.Utils;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static model.Buildings.REFUGIO;

public class Controller {
    private City city = new City();
    public void init() {
        readInput();
    }

    private void readInput() {
        Reader rd;
        String line;
        try {
            rd = new Reader("entrada");
            while(!(line = rd.readLine()).equals("")){
                executeLogic(line);
            }
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    private void executeLogic(String line) {
        try {
            selectorAction(line.split(" "));
            checkTemperature();
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }
    }
    private void executeLogic2(String line) {
        try {
            selectorAction2(line.split(" "));
            checkTemperature();
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }
    }
    private void checkTemperature() {
        city.getCircles().forEach(c -> c.getDistricts().forEach(d -> {
            if(d.getEdifice() != null && d.getEdifice().getName() == REFUGIO){
                Edifice edifice = d.getEdifice();
                if((edifice.getCurrentHeat() + city.getTemperature()) < edifice.getMinHeat()){
                    edifice.getPeople().forEach(p -> p.setSick(true));
                }
            }
        }));
    }

    private void selectorAction(String[] action) throws LogicException {
        switch (Utils.whichActionIs(action)){
            case ADD_EDIFICE:
                addEdifice(action);
                break;
            case MODIFY_TEMPERATURE:
                modifyTemperature(Integer.parseInt(action[1]));
                break;
            case ADD_PERSON_TO_REFUGE:
                addPersonToRefuge(action);
                break;
            case PRINT_REFUGE_PERSONS:
                printRefugePersons();
                break;
            case PRINT_CITY_INFO:
                printCityInformation();
                break;
            case ADD_JOB_PERSON:
                addJobPerson(action);
                break;
        }
    }
    private void selectorAction2(String[] action) throws LogicException {
        switch (Utils.whichActionIs(action)){
            case ADD_EDIFICE:
                addEdifice(action);
                break;
            case MODIFY_TEMPERATURE:
                modifyTemperature(Integer.parseInt(action[1]));
                break;
            case ADD_PERSON_TO_REFUGE:
                addPersonToRefuge(action);
                break;
            case ADD_JOB_PERSON:
                addJobPerson(action);
                break;
        }
    }
    //ACTIONS
    private void addJobPerson(String[] action) throws LogicException {
        int idCircle = Integer.parseInt(action[1].substring(1,2));
        int idDistrict = Integer.parseInt(action[1].substring(3,4));
        Edifice edifice = city.getDistrictByCircle(idCircle, idDistrict).getEdifice();
        Person person;
        if(edifice == null){
            throw new LogicException(LogicException.EDIFICE_IS_NOT_BUILDED);
        }
        if(edifice.getName() != REFUGIO){
            throw new LogicException(LogicException.EDIFICE_IS_NOT_A_REFUGE);
        }
        person = city.getPeopleSorted()
                .stream()
                .filter(p -> !p.isSick() && !p.isBusy())
                .findFirst()
                .orElse(null);
        if(person == null){
            throw new LogicException(LogicException.NOBODY_AVAILABLE);
        }
        idCircle = Integer.parseInt(action[2].substring(1,2));
        idDistrict = Integer.parseInt(action[2].substring(3,4));
        edifice = city.getDistrictByCircle(idCircle, idDistrict).getEdifice();
        if(edifice == null){
            throw new LogicException(LogicException.EDIFICE_IS_NOT_BUILDED);
        }
        if(edifice.getName() == REFUGIO){
            throw new LogicException(LogicException.EDIFICE_IS_A_REFUGE);
        }
        if (!edifice.addPerson(person)) {
            throw new LogicException(LogicException.PERSON_IS_NOT_ADDED);
        } else {
            throw new LogicException(LogicException.PERSON_ADD_JOB);
        }
    }

    private void printCityInformation() {
        AtomicInteger idCircle = new AtomicInteger();
        System.out.println("-- Mostrando Ciudad ---");
        city.getCircles().forEach(c -> {
            System.out.print("Circulo " + idCircle + "\n");
            AtomicInteger idDistrict = new AtomicInteger(1);
            c.getDistricts().forEach(d -> {
                System.out.print("\tSeccion " + idDistrict.get() + " " +
                        (d.getEdifice() == null
                                ? "calor: 3 Edificio: vacio\n"
                                : d.getEdifice().toString())
                );
                idDistrict.getAndIncrement();
            });
            idCircle.getAndIncrement();
        });
        System.out.println("-------------------------");
    }

    private void printRefugePersons() {
        System.out.println("-- Mostrando Personas ---");
        city.getPeopleSorted().forEach(System.out::println);
        System.out.println("-------------------------");
    }

    private void addPersonToRefuge(String[] action) throws LogicException {
        String namePerson = action[1];
        int circleId = Integer.parseInt(action[2].substring(1, 2));
        int districtId = Integer.parseInt(action[2].substring(3, 4));
        Person person = new Person(namePerson, circleId, districtId);
        Edifice edifice = city.getDistrictByCircle(circleId, districtId).getEdifice();

        if(edifice == null){
            throw new LogicException(LogicException.EDIFICE_IS_NOT_BUILDED);
        }
        if(edifice.getName() != REFUGIO){
            throw new LogicException(LogicException.EDIFICE_IS_NOT_A_REFUGE);
        }
        if (!(city.addPerson(person) && edifice.addPerson(person))) {
            throw new LogicException(LogicException.PERSON_IS_NOT_ADDED);
        } else {
            throw new LogicException(LogicException.EDIFICE_ADDED);
        }
    }

    private void modifyTemperature(int temperatureModification) {
        city.modifyTemperature(temperatureModification);
    }

    private void addEdifice(String[] action) throws LogicException {
        int circleId = Integer.parseInt(action[0].substring(1, 2));
        int districtId = Integer.parseInt(action[0].substring(3, 4));
        String nameEdifice = action[1];
        city.getDistrictByCircle(circleId, districtId)
                .setEdificeIfNull(Buildings.makeEdifice(nameEdifice));
        if(Buildings.valueOf(nameEdifice.toUpperCase()) == Buildings.MOTOR_VAPOR){
            circleId--;
            districtId--;
            Edifice edifice;
            for (int i = circleId; i < circleId + (3 - i); i++) {
                for (int j = districtId; j < districtId + (3 - i); j++) {
                    if(i > city.getCircles().size() - 1 || i < 0
                            || j > city.getCircles().get(i).getDistricts().size() - 1 || j < 0){
                        if ((edifice = city.getDistrictByCircle(i, j).getEdifice()) != null) {
                            edifice.plusCurrentHeat(edifice.getCurrentHeat() + 1);
                        }
                    }
                }
            }
        }
    }

    public void init2() {
        Scanner sc = new Scanner(System.in);
        executeLogic2(sc.nextLine());
    }

    public void goDowmTemperature() {
        city.modifyTemperature(-1);
    }
}

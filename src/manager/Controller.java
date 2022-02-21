package manager;

import dao.Reader;
import exceptions.ExecutionException;
import exceptions.LogicException;
import model.City;
import utils.Utils;

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
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }
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
    //ACTIONS
    private void addJobPerson(String[] action) {
    }

    private void printCityInformation() {
    }

    private void printRefugePersons() {
    }

    private void addPersonToRefuge(String[] action) {

    }

    private void modifyTemperature(int temperatureModification) {
        city.modifyTemperature(temperatureModification);
    }

    private void addEdifice(String[] action) {

    }

}

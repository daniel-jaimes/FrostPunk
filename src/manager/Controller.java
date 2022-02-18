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

    private static void readInput() {
        Reader rd;
        String line;
        try {
            rd = new Reader("entrada");
            while(!(line = rd.readLine()).equals("")){
                execute(line);
            }
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void execute(String line) {
        try {
            selectorAction(line);
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void selectorAction(String line) throws LogicException {
        switch (Utils.returnWhichActionIs(line)){
            default:
                System.out.println(line);
                break;
            /*
            case ADD_EDIFICE:
                break;
            case MODIFY_TEMPERATURE:
                break;
            case ADD_PERSON_TO_REFUGE:
                break;
            case PRINT_REFUGE_PERSONS:
                break;
            case PRINT_CITY_INFO:
                break;
            case ADD_JOB_PERSON:
                break;
             */
        }
    }

}

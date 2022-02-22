package utils;


import exceptions.LogicException;
import model.Buildings;

import java.util.Arrays;

public class Utils {
    /*
        Check the syntax of action line
    */
    public static Actions whichActionIs(String[] line) throws LogicException {
        //ACTION "S" - PRINT PERSON IN REFUGES
        if (checkSyntaxActionPrintPersonsInRefuges(line)) {
            return Actions.PRINT_REFUGE_PERSONS;
        }
        //ACTION "C" - PRINT ALL INFORMATION OF CITY
        if(checkSyntaxActionPrintInfoCity(line)){
            return Actions.PRINT_CITY_INFO;
        }
        //ACCION "T valor" - MODIFY TEMPERATURE
        if(checkSyntaxActionModifyTemperature(line)){
            return Actions.MODIFY_TEMPERATURE;
        }
        //ACCION "<circle, distrito> NombreEdificio" - ADD EDIFICE
        if(checkSyntaxActionAddEdifice(line)){
            return Actions.ADD_EDIFICE;
        }
        //ACCION "+ NombrePersona <circle, distrito>" - ADD PERSON TO REFUGE
        if(checkSyntaxActionAddPersonaToRefuge(line)){
            return Actions.ADD_PERSON_TO_REFUGE;
        }
        //ACCION " > <circleRefugio, distritoRefugio> <circleDestino, distritoDestino>" - ADD JOB ONE PERSONE
        if (checkSyntaxActionAddJobPerson(line)) {
            return Actions.ADD_JOB_PERSON;
        }

        throw new LogicException(LogicException.INCORRECT_ACTION);
    }
    //ACTION SYNTAX CHECKERS
    private static boolean checkSyntaxActionPrintInfoCity(String[] elementsLine) {
        return elementsLine.length == 1 && elementsLine[0].equalsIgnoreCase("C");
    }

    private static boolean checkSyntaxActionPrintPersonsInRefuges(String[] elementsLine) {
        return elementsLine.length == 1 && elementsLine[0].equalsIgnoreCase("S");
    }

    private static boolean checkSyntaxActionAddJobPerson(String[] elementsLine) {
        return elementsLine.length == 3 && elementsLine[0].length() == 1
                && elementsLine[0].equals(">") && isCordenate(elementsLine[1])
                && isCordenate(elementsLine[2]);
    }

    private static boolean checkSyntaxActionAddPersonaToRefuge(String[] elementsLine) {
        return elementsLine.length == 3 && elementsLine[0].equals("+") && isCordenate(elementsLine[2]);
    }

    private static boolean checkSyntaxActionAddEdifice(String[] elementsLine) {
        return elementsLine.length == 2 && isCordenate(elementsLine[0]) && isCorrectName(elementsLine[1]);
    }

    private static boolean checkSyntaxActionModifyTemperature(String[] elementsLine) {
        return elementsLine.length == 2 && elementsLine[0].length() == 1
                && (elementsLine[1].charAt(0) == '-' ? isDigit(elementsLine[1].substring(1)) : isDigit(elementsLine[1]));
    }

    private static boolean isDigit( String number){
        for (char digit : number.toCharArray()) {
            if (!Character.isDigit(digit)) return false;
        }
        return true;
    }
    private static boolean isCordenate(String cordenate){
        cordenate = cordenate
                .trim()
                .replaceAll(",", "")
                .substring(1, 3);

        return isDigit(cordenate);
    }
    private static boolean isCorrectName(String nameEdifice){
        return Arrays.asList(Buildings.values()).contains(Buildings.valueOf(nameEdifice.toUpperCase()));
    }

}

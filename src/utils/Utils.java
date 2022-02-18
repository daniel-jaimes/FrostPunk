package utils;


import exceptions.LogicException;
import model.Buildings;

import java.util.Arrays;

public class Utils {
    /*
        Check the syntax of action line
    */
    public static Actions returnWhichActionIs(String line) throws LogicException {

        String[] elementsLine = line.trim().split(" ");
        //ACTION "S" - PRINT PERSON IN REFUGES
        if (checkSyntaxActionPrintPersonsInRefuges(elementsLine)) {
            return Actions.PRINT_REFUGE_PERSONS;
        }
        //ACTION "C" - PRINT ALL INFORMATION OF CITY
        if(checkSyntaxActionPrintInfoCity(elementsLine)){
            return Actions.PRINT_CITY_INFO;
        }
        //ACCION "T valor" - MODIFY TEMPERATURE
        if(checkSyntaxActionModifyTemperature(elementsLine)){
            return Actions.MODIFY_TEMPERATURE;
        }
        //ACCION "<circle, distrito> NombreEdificio" - ADD EDIFICE
        if(checkSyntaxActionAddEdifice(elementsLine)){
            return Actions.ADD_EDIFICE;
        }
        //ACCION "+ NombrePersona <circle, distrito>" - ADD PERSON TO REFUGE
        if(checkSyntaxActionAddPersonaToRefuge(elementsLine)){
            return Actions.ADD_PERSON_TO_REFUGE;
        }
        //ACCION " > <circleRefugio, distritoRefugio> <circleDestino, distritoDestino>" - ADD JOB ONE PERSONE
        if (checkSyntaxActionAddJobPerson(elementsLine)) {
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
                && elementsLine[0].equals("+") && isCordenate(elementsLine[1])
                && isCordenate(elementsLine[2]);
    }

    private static boolean checkSyntaxActionAddPersonaToRefuge(String[] elementsLine) {
        return elementsLine.length == 3 && elementsLine[0].length() == 1
                && elementsLine[0].equals("+") && isCordenate(elementsLine[2]);
    }

    private static boolean checkSyntaxActionAddEdifice(String[] elementsLine) {
        return elementsLine.length == 2 && isCordenate(elementsLine[0]) && isCorrectName(elementsLine[1]);
    }

    private static boolean checkSyntaxActionModifyTemperature(String[] elementsLine) {
        return elementsLine.length == 2 && elementsLine[0].length() == 1 && isDigit(elementsLine[1]);
    }

    private static boolean isDigit( String number){
        for (char digit : number.toCharArray()) {
            if (!Character.isDigit(digit)) return false;
        }
        return true;
    }
    private static boolean isCordenate(String cordenate){
        cordenate
                .trim()
                .replaceAll(">", "")
                .replaceAll("<", "")
                .replaceAll(",", "");

        return isDigit(cordenate);
    }
    private static boolean isCorrectName(String nameEdifice){
        return Arrays.asList(Buildings.values()).contains(Buildings.valueOf(nameEdifice));
    }

}

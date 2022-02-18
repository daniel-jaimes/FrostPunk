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

        if (elementsLine.length == 1 ){
            //ACTION "S" - PRINT PERSON IN REFUGES
            if (elementsLine[0].equalsIgnoreCase("S")){
                return Actions.PRINT_REFUGE_PERSONS;
            }
            //ACTION "C" - PRINT ALL INFORMATION OF CITY
            if (elementsLine[0].equalsIgnoreCase("C")){
                return Actions.PRINT_CITY_INFO;
            }
        }
        if (elementsLine.length == 2){
            //ACCION "T valor" - MODIFY TEMPERATURE
            if (elementsLine[0].length() == 1 && isDigit(elementsLine[1])){
                return Actions.MODIFY_TEMPERATURE;
            }
            //ACCION "<circle, distrito> NombreEdificio" - ADD EDIFICE
            if (isCordenate(elementsLine[0]) && isCorrectName(elementsLine[1])){
                return Actions.ADD_EDIFICE;
            }
        }
        if (elementsLine.length == 3){
            //ACCION "+ NombrePersona <circle, distrito>" - ADD PERSON TO REFUGE
            if (elementsLine[0].length() == 1 && elementsLine[0].equals("+") && isCordenate(elementsLine[2])){
                return Actions.ADD_PERSON_TO_REFUGE;
            }
            //ACCION " > <circleRefugio, distritoRefugio> <circleDestino, distritoDestino>" - ADD JOB ONE PERSONE
            if (elementsLine[0].length() == 1 && elementsLine[0].equals("+")
                    && isCordenate(elementsLine[1]) && isCordenate(elementsLine[2])){
                return Actions.ADD_JOB_PERSON;
            }
        }

        throw new LogicException(LogicException.INCORRECT_ACTION);
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

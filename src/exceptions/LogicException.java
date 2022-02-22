package exceptions;

import java.util.Arrays;
import java.util.List;

public class LogicException extends Exception{
    public static final int INCORRECT_ACTION = 0;
    public static final int INCORRECT_NAME_EDIFICE = 1;
    public static final int PLOT_IS_NOT_EMPTY = 2;
    public static final int EDIFICE_IS_NOT_BUILDED = 3;
    public static final int EDIFICE_IS_NOT_A_REFUGE = 4;
    public static final int PERSON_IS_NOT_ADDED = 5;
    public static final int EDIFICE_IS_A_REFUGE = 6;
    public static final int NOBODY_AVAILABLE = 7;
    public static final int EDIFICE_ADDED = 8;
    public static final int PERSON_ADD_JOB = 9;
    private int value;
    private List<String> message = Arrays.asList(
            "<< La accion es incorrecta. >>",
            "<< El nombre del edificio no existe >>",
            "<< La parcela no está vacia >>",
            "<< No hay un edificio en esta parcela >> ",
            "<< El edificio no es un refugio >>",
            "<< Person NO added >>",
            "<< No se puede mover de un refugio a otro >>",
            "<< No hay nadie disponible >>",
            "<< Edificio added >>",
            "<< Persona added >>\n<< Persona asignada >>"
    );
    public LogicException(int value){
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message.get(value);
    }
}

package exceptions;

import java.util.Arrays;
import java.util.List;

public class LogicException extends Exception{
    public static final int INCORRECT_ACTION = 0;
    public static final int INCORRECT_NAME_EDIFICE = 1;
    public static final int EDIFICE_CORRECTED_ADDED = 2;
    public static final int PLOT_IS_NOT_EMPTY = 3;
    private int value;
    private List<String> message = Arrays.asList(
            "<< La accion es incorrecta. >>",
            "<< El nombre del edificio no existe >>",
            "<< Edificio added >>",
            "<< La parcela no está vacia >>"
    );
    public LogicException(int value){
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message.get(value);
    }
}

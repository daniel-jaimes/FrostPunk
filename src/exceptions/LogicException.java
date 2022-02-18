package exceptions;

import java.util.Arrays;
import java.util.List;

public class LogicException extends Exception{
    public static final int INCORRECT_ACTION = 0;
    public static final int INCORRECT_NAME_EDIFICE = 1;
    private int value;
    private List<String> message = Arrays.asList(
            "<< La accion es incorrecta. >>",
            "<< El nombre del edificio no existe >>"
    );
    public LogicException(int value){
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message.get(value);
    }
}

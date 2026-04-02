package Server.utility;

public class StringConverter extends javafx.util.StringConverter<Number> {

    @Override
    public String toString(Number number) {
        return number == null || number.intValue() == 0 ? "" : number.toString();
    }

    @Override
    public Number fromString(String string) {
        try
        {
            return Integer.parseInt(string);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}

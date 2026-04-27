import java.util.HashMap;
import java.util.Map;

public class Valuables {
    private String type;
    private int value;
    private static Map<String,Valuables>valuables=new HashMap<>();

    private Valuables(String type,int value){
        this.type=type;
        this.value=value;

    }
    public static Valuables getInstance(String key)
    {
        if (!valuables.containsKey(key))
        {
            int newValue = 0;
            switch (key)
            {
                case "Diamond":
                    newValue = 100;
                    break;
                case "Ruby":
                    newValue = 75;
                    break;
                case "Jewel":
                    newValue = 50;
                    break;
                case "GoldNugget":
                    newValue = 25;
                    break;
                case "WoodenCoin":
                    newValue = 1;
                    break;
                case "Wooden figurines":
                    newValue = 2;
                    break;
                case "Ram sticks":
                    newValue = 5;
                    break;
            }

            if (newValue == 0)
            {
                throw new IllegalArgumentException("You can't mine that");
            }

            synchronized (valuables)
            {
                if (!valuables.containsKey(key))
                {
                    valuables.put(key, new Valuables(key, newValue));
                }
            }
        }
        return valuables.get(key);
    }
    public int getValue()
    {
        return value;
    }

    public String getType()
    {
        return type;
    }
}

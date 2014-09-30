package is.ru.honn.ruber.parser;

import org.json.simple.JSONObject;

/**
 * Contains a method used for making a pretty JSON string
 */
public class JsonParse {

    /**
     * This function makes a jsonString that is pretty to look at
     * @param jsonObject
     * the original string
     * @return StringBuilder
     */
    public static StringBuilder PurdyJson(JSONObject jsonObject)
    {
        StringBuilder returnString = new StringBuilder();
        String jsonString = jsonObject.toJSONString();
        String openBrace = "{";
        String openBracket = "[";
        String comma = ",";
        String closeBrace = "}";
        String closeBracket = "]";
        String colon = ":";
        String conCat = null;
        int numberOfTabs = 0;

        for(char c : jsonString.toCharArray())
        {
            if((c == openBrace.charAt(0) || (c == openBracket.charAt(0)) || (c == comma.charAt(0))))
            {
                conCat = c + "\n";
                returnString.append(conCat);

                if(c == openBrace.charAt(0) || (c == openBracket.charAt(0)))
                {
                    numberOfTabs++;
                }
                for(int i = 0; i < numberOfTabs; i++)
                {
                    returnString.append("\t");
                }
            }
            else if((c == closeBrace.charAt(0) || (c == closeBracket.charAt(0))))
            {
                returnString.append("\n");
                numberOfTabs--;

                for(int i = 0; i < numberOfTabs; i++)
                {
                    returnString.append("\t");
                }
                returnString.append(c);
            }
            else
            {
                if(c == colon.charAt(0))
                {
                    conCat = c + " ";
                    returnString.append(conCat);
                }
                else{
                    returnString.append(c);
                }
            }
        }
        return returnString;
    }
}

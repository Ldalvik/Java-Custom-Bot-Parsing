package AiRoot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Utils {

    public static JSONObject parser(String str) {
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            Object obj = parser.parse(new FileReader(str));
            json = (JSONObject) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static int Random(JSONArray array) {
        int rnd = new Random().nextInt(array.size());
        return rnd;
    }

    public static void work(JSONObject holder, JSONArray array, String message, String[] responses){
        holder.put(message, array);
        String[] response = responses;
        for(int i=0; i<response.length; i++) {
            array.add(response[i]);
            System.out.println("Added response \""+response[i]+"\" to message \""+message+"\"");
        }
    }

    public static String deleteAfter(String msg, String trim){
        return msg.substring(0, msg.indexOf(trim));
    }

    public static String pick(JSONObject json, String message){

        JSONArray array = (JSONArray) json.get(message);
        int random = Random(array);
        return (String) array.get(random);
    }

    public static String Bot(String input, String dir){

        JSONObject fullJSON = parser(dir);

        String input2 = input.replaceAll("[^0-9a-zA-Z_\\s]","");

        String input3 = deleteAfter(input2, " ").trim();

       return pick(fullJSON,input3);
    }

    public static void add(String dir, String message, String[] helloResponses){
        JSONObject holder = new JSONObject();
        JSONArray array = new JSONArray();

        work(holder, array, message, helloResponses);

        try (FileWriter file = new FileWriter(dir)) {
            file.write(holder.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

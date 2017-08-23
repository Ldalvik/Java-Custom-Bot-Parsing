package AiRoot;

import java.io.*;
import java.util.Random;
import java.util.StringJoiner;

import static AiRoot.Utils.*;

public class Read {

    private static StringBuilder contents;

   void getContents(String dir) {
        contents = new StringBuilder();
        try {
            File aFile = new File(dir);
            try (BufferedReader input = new BufferedReader(new FileReader(aFile))) {
                String line;
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append("\n");
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
   }

    private String getFallback() {
        String[] messages = contents.toString().split("\n");
        StringJoiner sb = new StringJoiner("\n");
        for (String message : messages) {
            if (message.startsWith("[fallback:")) {
                sb.add(GetFallback(message));
            }
        }
        String[] array = sb.toString().split("\n");
        Random r = new Random();
        int random = r.nextInt(array.length);
        return array[random];
    }
    String getResponse(String msg){
       String result;
       String[] messages = contents.toString().split("\n");
        StringJoiner sb = new StringJoiner("\n");
        for (String message : messages) {
            if (message.startsWith("<" + msg + ">")) {
                sb.add(GetMessage(message, msg));
            }
        }
        if(sb.toString().isEmpty()) {
            result = getFallback();
        } else {
            String[] array = sb.toString().split("\n");
            int random = Random(array);
            result = array[random];
        }
        return result;
    }
}


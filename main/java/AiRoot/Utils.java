package AiRoot;

import java.util.Random;

class Utils {

    static int Random(String[] array) {
        return new Random().nextInt(array.length);
    }

    static String GetInput(String str, String input){
        return str.substring(str.length()-2-input.length()).replace(">", "");
    }
    static String GetMessage(String str, String input){
        return str.replaceAll("<"+input+">", "");
    }
    static String GetFallback(String str){
        //int msg_length = str.length()-input.length()*2-4;
        return str.replace("[fallback:", "").replace("]","");
    }
}

package AiRoot;


import static AiRoot.Utils.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting A.I.");

        String dir = "C:\\Users\\subar\\Desktop\\ai_root\\src\\main\\rootJSON\\default.json";

        String input = "Hello! How are you?";
        String response = Bot(input, dir);
        System.out.println(response);

        String[] hello = {"Hey", "What's up?", "Hi!", "Hello"};
        add(dir, "Hello", hello);




/*  create new .json if needed
    JSONObject jObj = new JSONObject();
    jObj.put("", "");
    try (FileWriter file = new FileWriter(dir + "default.json")) {
        file.write(jObj.toJSONString());
        file.flush();
*/

    }
}

import java.util.ArrayList;
import java.util.Arrays;
public class UserInput {
    private ArrayList<String> words=new ArrayList<String>();
    public UserInput(){
        words.add("read");
        words.add("exercise");
        words.add("ask");
        words.add("money");
        words.add("sell");
        words.add("bond");
        words.add("next");
        words.add("buy");
    }
    public int interpretToken(String input){
        String lowerInput=input.toLowerCase();
        String[] userInput=lowerInput.split(" ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(userInput));
        for(int i=0;i<wordsList.size();i++){
            switch(wordsList.get(i)){
                case "read":
                return 1;
                case "exercise":
                return 2;
                case "ask":
                if(wordsList.contains("money")){
                    return 3;
                }
                case "sell":
                if(wordsList.contains("house")){
                    return 4;
                }
            }
        }
        return 0;
    }

}


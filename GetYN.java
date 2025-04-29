/*
 * GetYN get the user input "yes" or "no" and transform this to boolean for the game to run. 
 * @version: April 29, 2025
 */
public class GetYN {
    public GetYN(){
    }
    public boolean yesOrNo(String input){
        if(input.charAt(0)=='y' || input.charAt(0)=='Y'){
            return true;
        }
        if(input.charAt(0)=='n' || input.charAt(0)=='N'){
            return false;
        } else{
            throw new RuntimeException();
        }
    }

}
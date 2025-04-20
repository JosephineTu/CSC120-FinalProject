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
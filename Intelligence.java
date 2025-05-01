/*
 * Intelligence class that stores Intelligence related methods
 * @ version: April 29, 2025
 */
public class Intelligence {
    
    // Attributes
    private boolean inSchool;
    private DEGREE degree;
    public int value;

    /*
     * Contructor
     * @param int value
     */
    public Intelligence(int value){
        this.inSchool = false;
        this.degree = null;
        this.value = value;
    }
    public boolean getinSchool(){
        return this.inSchool;
    }
    /*
     * put the player into school by changing degree to Elementary, and boolean inSchool to true. 
     */
    public void goToSchool(){
        this.degree=DEGREE.Elementary;
        this.inSchool=true;
        System.out.println("You are now enrolled in primary school.");
    }
    /*
     * adds 3 to the current int value, capped at 100
     */
    public void readBook(){
        if(this.value<97){
            this.value+=3;
        } else{
            this.value=100;
        }
    }

    /*
     * use if statement comparison to determine whether the player should still remain in school. 
     * If passes exam, modify the highest degree.
     */
    public void takeExam(){ 
        if(this.degree==DEGREE.Elementary){
            if(this.value<75){
                dropOut();
            } else{
                this.degree=DEGREE.Secondary;
                System.out.println("You now entered secondary school.");
            }
        }
        else if(this.degree==DEGREE.Secondary){
            if(this.value<80){
                dropOut();
            } else{
                this.degree=DEGREE.HighSchool;
                System.out.println("You now entered high school.");
            }
        }
        else if(this.degree==DEGREE.HighSchool){
            if(this.value<85){
                dropOut();
            } else{
                this.degree=DEGREE.Bachelor;
                System.out.println("You now entered college!");
            }
        }
        else if(this.degree==DEGREE.Bachelor){
            if(this.value<90){
                dropOut();
            } else{
                this.degree=DEGREE.Master;
                System.out.println("You are now enrolled in a Master program.");
            }
        }
        else if(this.degree==DEGREE.Master){
            if(this.value!=100){
                dropOut();
            } else{
                this.degree=DEGREE.PhD;
                System.out.println("Congrats on your acceptance to the Doctorate program!");
            }
        }
    }
    /*
     * indicate whether the player drop out of school, and print the highest degree earned. 
     */
    public void dropOut(){
        this.inSchool=false;
        System.out.println("You are no longer in school. Your highest degree earned is "+this.degree+".");
    }
    public DEGREE getDegree(){
        return this.degree;
    }
}
    
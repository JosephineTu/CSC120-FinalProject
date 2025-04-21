public class Intelligence {
    
    private boolean inSchool;
    private DEGREE degree;
    private int value;

    public Intelligence(int value){
        this.inSchool = false;
        this.degree = null;
        this.value = value;
    }
    public void goToSchool(){
        this.degree=DEGREE.Elementary;
        this.inSchool=true;
        System.out.println("You are now enrolled in primary school.");
    }
    public void readBook(){
        // adds 3 to the current value, capped at 100
        if(this.value<97){
            this.value+=3;
        } else{
            this.value=100;
        }
    }

    public void takeExam(){
        // use if statement comparison to determine whether the player should still remain in school, if passes exam, modify the highest degree.
        if(this.degree==DEGREE.Elementary){
            if(this.value<75){
                dropOut();
            } else{
                this.degree=DEGREE.Secondary;
            }
        }
        else if(this.degree==DEGREE.Secondary){
            if(this.value<80){
                dropOut();
            } else{
                this.degree=DEGREE.HighSchool;
            }
        }
        else if(this.degree==DEGREE.HighSchool){
            if(this.value<85){
                dropOut();
            } else{
                this.degree=DEGREE.Bachelor;
            }
        }
        else if(this.degree==DEGREE.Bachelor){
            if(this.value<90){
                dropOut();
            } else{
                this.degree=DEGREE.Master;
            }
        }
        else if(this.degree==DEGREE.Master){
            if(this.value!=100){
                dropOut();
            } else{
                this.degree=DEGREE.PhD;
            }
        }
    }
    public void dropOut(){
        this.inSchool=false;
        System.out.println("You are no longer in school. Your highest degree earned is "+this.degree+".");
    }
}
    
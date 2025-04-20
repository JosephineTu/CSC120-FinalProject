public class Intelligence {
    
    private boolean inSchool;
    private DEGREE degree;
    private int value;

    public Intelligence(int value){
        this.inSchool = false;
        this.degree = null;
        this.value = value;
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
    }
    public void dropOut(){
        this.inSchool=false;
    }

    public void getDegree(){
        if (this.degree == null){
            this.degree = "kindergarten";
        } elif (this.degree == "kindergarten"){
            this.degree = "elementary school";
        } elif (this.degree == "elementary school"){
            this.degree = "middle school";
        } elif (this.degree == "middle school"){
            this.degree = "high school";
        } elif (this.degree == "high school"){
            this.degree = "bachelor degree";
        } elif (this.degree == "bachelor degree"){
            Scanner s = new Scanner(System.in);
            System.out.println("If you are pursing master degree, type '1', if phD, type '2': ");
            int purse = s.nextInt();
            if (pursue == 1){
                this.degree = "master degree";
            } elif (pursue == 2){
                this.degree = "phD";
            }
        } elif (this.degree == "master degree"){
            this.degree = "phD";
        }
    }
}

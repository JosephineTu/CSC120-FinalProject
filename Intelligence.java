public class Intelligence {
    
    private boolean inSchool = false;
    private String degree = none;
    private int value = 0;

    public Integlligence(boolean inSchool, String degree, int value){
        this.inSchool = inSchool;
        this.degree = degree;
        this.value = value;
    }

    public void readBook(){
        // random number generator?
        this.value += 30;
    }

    public void takeExam(){
        // random number generator?
        this.value += 30;
    }

    public void getDegree(){
        if (this.degree == none){
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

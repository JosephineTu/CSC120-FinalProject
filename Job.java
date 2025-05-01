public class Job {
    
    //attributes
    public String name;
    public DEGREE leastDegreeRequired;
    public int annualIncome;

    /**
     * Constructor
     * @param name
     * @param leastDegreeRequired
     * @param annualIncome
     */
    public Job(String name,DEGREE leastDegreeRequired,int annualIncome){
        this.name=name;
        this.leastDegreeRequired=leastDegreeRequired;
        this.annualIncome=annualIncome;
    }
}

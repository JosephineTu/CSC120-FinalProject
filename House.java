/*
 * House class that stores the methods for House
 * @version: April 29, 2025
 */
public class House {
    //Attributes
    String name;
    public double price;
    int timeBought=0;
    int growthType;
    /*
     * Constructor
     * @param String name
     * @param double price
     * @param growthType
     */
    public House(String name,double price,int growthType){
        this.name=name;
        this.price=price;
        this.growthType=growthType;
    }
    /*
     * calculate the current price of the house based on the growthType and difference between currentTime and timeBought
     * @param int currentTime
     * @return int price
     */
    public int getPrice(int currentTime){
        if(this.growthType==1){
            return (int)(this.price+1* Math.pow(1.05, (currentTime - timeBought)));
        }else if(this.growthType==2){
            return (int)(this.price);
        }else if(this.growthType==3){
            return (int)(this.price+1*Math.pow(0.95, (currentTime - timeBought)));
        }else{
            return (int)(this.price);
        }

    }
    /*
     * print the name and price of a house in the property. 
     * @param House b
     * @return String house
     */
    public String toString(House b){
        String house=b.name+","+b.price+"USD.";
        return house;
    }

}

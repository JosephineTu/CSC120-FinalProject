public class House {
    String name;
    double price;
    int timeBought=0;
    int growthType;
    public House(String name,int price,int growthType){
        this.name=name;
        this.price=price;
        this.growthType=growthType;
    }
    public int getPrice(int currentTime){
        if(this.growthType==1){
            return (int)(this.price * Math.pow(1.05, (currentTime - timeBought)));
        }else if(this.growthType==2){
            return (int)(this.price);
        }else if(this.growthType==3){
            return (int)(this.price * Math.pow(0.95, (currentTime - timeBought)));
        }else{
            return (int)(this.price);
        }

    }

}

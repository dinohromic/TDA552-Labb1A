public class CarFactory {
    public static Vehicle MakeVolvo(int x, int y){
        return new Volvo240(0,x,y);
    }

    public static Vehicle MakeSaab(int x, int y){
        return new Saab95(0, x, y);
    }

    public static Vehicle MakeScania(int x, int y){
        return new Scania(0, x, y);
    }
}

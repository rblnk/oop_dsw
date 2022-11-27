public class SpeedKnot {
    private double speedKnot;
    private int i=0;

    public SpeedKnot(double speedKnot){

        this.speedKnot = speedKnot;
    }

    public double getSpeedKnot() {

        return speedKnot;
    }

    public void toMs(){
        this.speedKnot= this.speedKnot*0.51;
        i++;
    }

    @Override
    public String toString(){
        if (i == 0)
            return speedKnot + " Kt";
        else
            return speedKnot + " m/s";
    }
}

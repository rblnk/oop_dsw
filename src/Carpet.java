public class Carpet extends Vector{

    private double distance;

    public Carpet(Direction direction, SpeedMs speedMs) {

        super(direction, speedMs);
    }

    public double getDistance() {

        return distance;
    }

    public void setDistance(double distance) {

        this.distance = distance;
    }

    public void distanceToMeters(){

        this.distance= this.distance*1000;
    }

// Obliczanie czasu
    public double calculateTime() {

        return this.distance / this.speed;
    }

// Obliczanie drogi
    public double calculateRoad(double time) {

        return this.speed*time;
    }

// Obliczanie predkosci
    public double calculateSpeed(double time) {

        return this.distance/time;
    }
}

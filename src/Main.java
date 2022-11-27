public class Main {
    public static void main(String[] args) {


//   Zadanie A, koncert Young Leosi

        Time timeStartA = new Time(17,0,0);
        Time timeEndA = new Time(20,30,0);
        Time timeA = new Time();

        timeA.setTime(timeStartA);

        SpeedMs speedOfCarpetA = new SpeedMs(25);
        SpeedKnot speedOfWindA = new SpeedKnot(10);

        speedOfWindA.toMs();

        Carpet carpetA = new Carpet(Direction.WEST,speedOfCarpetA);
        carpetA.setDistance(300);
        Vector windA = new Wind(Direction.WEST, speedOfWindA);

        carpetA.addVectors(windA);

        carpetA.distanceToMeters();

        timeA.addSecond((int) carpetA.calculateTime());

        System.out.println("*********** Zadanie A, koncert Young Leosi ***********");
        System.out.print("Czy Mag zdazy na koncert, ktory zaczyna sie o godzinie 20:30? ");
        if (timeA.isBefore(timeEndA)){
            System.out.println("Tak");}
        else {
                System.out.println("Nie");
            }
        System.out.println("Mag bedzie na miejscu o " + timeA);
        System.out.println();


//   Zadanie B, na plazy w Stegnie

        SpeedMs speedOfCarpetB = new SpeedMs(25);
        SpeedKnot speedOfWind1B = new SpeedKnot(2);
        SpeedKnot speedOfWind2B = new SpeedKnot(3);

        Time timeStartB = new Time(11,20,0);
        Time timeOfWindChangingB = new Time(2,30,0);

        speedOfWind1B.toMs();
        speedOfWind2B.toMs();

        Carpet carpetB = new Carpet(Direction.NORTH, speedOfCarpetB);
        Vector wind1B = new Wind(Direction.SOUTH, speedOfWind1B);
        Vector wind2B = new Wind(Direction.EAST, speedOfWind2B);

        carpetB.setDistance(500);
        carpetB.distanceToMeters();

        carpetB.addVectors(wind1B);

        double firstWindDistance = carpetB.calculateRoad(timeOfWindChangingB.toSeconds());
        double secondWindDistance = carpetB.getDistance() - firstWindDistance;

        carpetB.setDistance(secondWindDistance);

        carpetB.setSpeed(speedOfCarpetB.getSpeedMs());
        carpetB.addVectors(wind2B);

        double secondTime = carpetB.calculateTime();


        timeStartB.addSecond(timeOfWindChangingB.toSeconds());
        timeStartB.addSecond((int) secondTime);

        System.out.println("********** Zadanie B, na plazy w Stegnie ***********");
        System.out.println("O ktorej Mag przyleci do Wrocławia?");
        System.out.println("Mag przyleci do Wrocławia o "+ timeStartB);
        System.out.println();


//   Zadanie C, spotkanie na szczycie
        Time timeStart1C = new Time(10,15,0);
        Time timeStart2C = new Time(10,30,0);
        Time timeC = new Time();

        timeC.setTime(timeStart1C);

        SpeedMs speedOfCarpetC = new SpeedMs(25);
        SpeedKnot speedOfWindC = new SpeedKnot(8);

        speedOfWindC.toMs();

        Carpet carpet1C = new Carpet(Direction.WEST, speedOfCarpetC);
        Vector carpet2C = new Carpet(Direction.EAST, speedOfCarpetC);

        Vector windC = new Wind(Direction.WEST, speedOfWindC);

        SpeedMs commonSpeedC = new SpeedMs();

        carpet1C.addVectors(windC);
        carpet2C.addVectors(windC);

        carpet1C.setDistance(270);
        carpet1C.distanceToMeters();

        double firstCarpetTime = timeStart2C.toSeconds()-timeStart1C.toSeconds();
        double firstCarpetDistance = carpet1C.calculateRoad(firstCarpetTime);

        double commonDistance = carpet1C.getDistance()-firstCarpetDistance;

        commonSpeedC.setSpeedMs(carpet1C.getSpeed()+carpet2C.getSpeed());

        Carpet commonC = new Carpet(Direction.WEST, commonSpeedC);

        commonC.setDistance(commonDistance);

        double meetTime = commonC.calculateTime();

        timeC.setTime(timeStart2C);
        timeC.addSecond((int)meetTime);

        double howLongMageFly = timeC.toSeconds()-timeStart1C.toSeconds();

        double meetPoint = carpet1C.calculateRoad(howLongMageFly);

        System.out.println("********** Zadanie C, Spotkanie na szczycie **********");
        System.out.println("W jakiej odleglosci od Wrocławia i o ktorej godzinie spotkaja sie Magowie?");
        System.out.println("Magowie spotkają się o " + timeC + " w odległości " + meetPoint + " m od Wrocławia");
        System.out.println();


//   Zadanie D, kontrola predkosci
        Time travelTimeD = new Time(0,40,0);
        SpeedMs speedOfCarpetD = new SpeedMs();
        SpeedKnot speedOfWindD = new SpeedKnot(4);
        SpeedKnot limitSpeed = new SpeedKnot(40);

        speedOfWindD.toMs();

        Carpet carpetD = new Carpet(Direction.EAST, speedOfCarpetD);
        Vector windD = new Wind(Direction.EAST, speedOfWindD);

        double time = travelTimeD.toSeconds();

        carpetD.setDistance(70);

        carpetD.distanceToMeters();

        double newSpeed = carpetD.calculateSpeed(time);

        speedOfCarpetD.setSpeedMs(newSpeed);
        carpetD.setSpeed(newSpeed);

        carpetD.addVectors(windD);

        limitSpeed.toMs();

        System.out.println("********** Zadanie D, Kontrola prędkości **********");
        System.out.println("Mag poruszał się z prędkością " + carpetD.getSpeed() + "m/s, a ograniczenie prędkości wynosi " + limitSpeed);
        System.out.print("Czy Mag przekroczyl predkosc? ");
        if((carpetD.getSpeed()>limitSpeed.getSpeedKnot())){
            System.out.println("Tak");
        } else {
            System.out.println("Nie");
        }


    }
}

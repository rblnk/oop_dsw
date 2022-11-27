public class Vector {

    protected Direction direction;
    protected double speed;

    public Vector(Direction direction, SpeedKnot speedKnot) {
        this.direction = direction;
        this.speed = speedKnot.getSpeedKnot();
    }

    public Vector(Direction direction, SpeedMs speedMs) {
        this.direction = direction;
        this.speed = speedMs.getSpeedMs();
    }
    public double getSpeed() {

        return speed;
    }

    public void setSpeed(double speed) {

        this.speed = speed;
    }

    // Dodawanie wektorów
    public void addVectors(Vector vector) {
        switch (this.direction) {
            case EAST:
                if (vector.direction == Direction.EAST) {
                    this.speed += vector.speed;
                } else if (vector.direction == Direction.WEST) {
                    this.speed -= vector.speed;
                }
                break;
            case WEST:
                if (vector.direction == Direction.WEST) {
                    this.speed += vector.speed;
                } else if (vector.direction == Direction.EAST) {
                    this.speed -= vector.speed;
                }
                break;
            case NORTH:
                if (vector.direction == Direction.NORTH) {
                    this.speed += vector.speed;
                } else if (vector.direction == Direction.SOUTH) {
                    this.speed -= vector.speed;
                }
                break;
            case SOUTH:
                if (vector.direction == Direction.SOUTH) {
                    this.speed += vector.speed;
                } else if (vector.direction == Direction.NORTH) {
                    this.speed -= vector.speed;
                }
                break;
        }
    }
}

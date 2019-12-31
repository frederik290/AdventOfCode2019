public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;
    private int stepsTaken;

    public int getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public Coordinate(int x, int y, int stepsTaken){
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.stepsTaken = stepsTaken;
    }

    public Coordinate(int x, int y){
        this(x, y, 0);
    }

    public int getXCoord() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoord() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString(){
        return this.xCoordinate + "," + this.yCoordinate;
    }

    @Override
    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        Coordinate verifyee = (Coordinate) other;

        return (this.xCoordinate == verifyee.xCoordinate) && this.yCoordinate == verifyee.yCoordinate;
    }
}

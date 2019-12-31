import java.util.ArrayList;
import java.util.Arrays;

public class CrossedWires {

    public CrossedWires(){
    }


    public int getClosestIntersectionDistanceByManhattanDistance(String[] redWirePath, String[] blueWirePath){
        ArrayList<Coordinate> blueWire = createWire(blueWirePath);
        ArrayList<Coordinate> redWire = createWire(redWirePath);
        redWire.retainAll(blueWire);

        int result = -1;
        Coordinate resultCoordinate = new Coordinate(0,0);

        for(int i = 0; i < redWire.size(); i++){
            Coordinate coord = redWire.get(i);
            int distance = Math.abs(coord.getXCoord()) + Math.abs(coord.getYCoord());

            if((result == -1 || distance < result) && distance != 0){
                result = distance;
                resultCoordinate = coord;
            }
        }
        printManhattanResult(resultCoordinate, redWire);
        return result;
    }

    public int getClosestIntersectionDistanceByMinimumSteps(String[] redWirePath, String[] blueWirePath){
        ArrayList<Coordinate> blueWire = createWire(blueWirePath);
        ArrayList<Coordinate> redWire = createWire(redWirePath);
        ArrayList<Coordinate> intersections = (ArrayList<Coordinate>) redWire.clone();
        intersections.retainAll(blueWire);

        int result = -1;
        Coordinate redResultCoordinate = new Coordinate(0,0);
        Coordinate blueResultCoordinate = new Coordinate(0,0);

        for(int i = 0; i < intersections.size(); i++){
            Coordinate intersection = intersections.get(i);
            int redIndex = redWire.indexOf(intersection);
            int blueIndex = blueWire.indexOf(intersection);
            Coordinate redCoord = redWire.get(redIndex);
            Coordinate blueCoord = blueWire.get(blueIndex);
            int totalSteps = redCoord.getStepsTaken() + blueCoord.getStepsTaken();

            if((result == -1 || totalSteps < result) && redIndex != 0 && blueIndex != 0){
                result = totalSteps;
                redResultCoordinate = redCoord;
                blueResultCoordinate = blueCoord;
            }
        }

        System.out.println("Red wire steps: " + redResultCoordinate.getStepsTaken());
        System.out.println("Blue wire steps: " + blueResultCoordinate.getStepsTaken());
        return result;
    }

    public ArrayList<Coordinate> createWire(String[] wirePath){
        ArrayList<Coordinate> wire = new ArrayList<>();
        int amount;
        String direction;
        Coordinate prevCoordSet;
        int prevXCoord;
        int prevYCoord;
        int prevStepsTaken;
        wire.add(0, new Coordinate(0,0));

        for(int i = 0; i < wirePath.length; i++){
            direction = wirePath[i].substring(0,1);
            amount = Integer.parseInt(wirePath[i].substring(1));
            prevCoordSet = wire.get(wire.size()-1);
            prevXCoord = prevCoordSet.getXCoord();
            prevYCoord =prevCoordSet.getYCoord();
            prevStepsTaken = prevCoordSet.getStepsTaken();

            switch (direction){
                case "U":
                    for(int a = 1; a <= amount; a++){
                        wire.add(new Coordinate(prevXCoord, prevYCoord + a, prevStepsTaken + a));
                    }
                    break;
                case "D":
                    for(int a = 1; a <= amount; a++){
                        wire.add(new Coordinate(prevXCoord, prevYCoord - a, prevStepsTaken + a));
                    }
                    break;
                case "L":
                    for(int a = 1; a <= amount; a++){
                        wire.add(new Coordinate(prevXCoord - a, prevYCoord, prevStepsTaken + a));
                    }
                    break;
                case "R":
                    for(int a = 1; a <= amount; a++){
                        wire.add(new Coordinate(prevXCoord + a, prevYCoord, prevStepsTaken + a));
                    }
                    break;
            }
        }
        return wire;
    }

    public void printManhattanResult(Coordinate resultCoordinate, ArrayList<Coordinate> list){
        System.out.println("Wires intersect at:");
        for(Coordinate coord : list){
            System.out.println(coord.toString());
        }
        System.out.println("Closest intersection is: " + resultCoordinate);
    }
}


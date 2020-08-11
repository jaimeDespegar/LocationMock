package implementation;

import model.Coordinate;
import model.LocationConnector;
import java.util.Arrays;
import java.util.List;

public class ApiLocationMock implements LocationConnector {

    private Boolean isActive;

    @Override
    public Boolean isAvailable() {
        return isActive;
    }

    @Override
    public Boolean on() {
        this.isActive = Boolean.TRUE;
        return true;
    }

    @Override
    public Boolean off() {
        this.isActive = Boolean.FALSE;
        return true;
    }

    @Override
    public List<Coordinate> getData(Coordinate arrival, Coordinate departure) {
        List<Coordinate> resultOne = Arrays.asList(new Coordinate(11, 22), new Coordinate(15, 23), new Coordinate(33, 44));
        List<Coordinate> resultTwo = Arrays.asList();
        List<Coordinate> resultThree = Arrays.asList(new Coordinate(22, 66));

        if (arrival.equals(new Coordinate(11, 22)) && departure.equals(new Coordinate(33, 44))) {
            return resultOne;
        }
        if (arrival.equals(new Coordinate(23, 41)) && departure.equals(new Coordinate(50, 60))) {
            return resultTwo;
        }
        if (arrival.equals(new Coordinate(22, 66)) && departure.equals(new Coordinate(22, 66))) {
            return resultThree;
        }
        return resultTwo;
    }

}
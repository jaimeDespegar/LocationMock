package implementation;

import com.google.common.collect.Lists;
import model.Coordinate;
import model.LocationConnector;
import model.LocationSearchDto;
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
    public List<Coordinate> getData(LocationSearchDto locationSearchDto) {
        List<Coordinate> resultOne = Lists.newArrayList(new Coordinate(11, 22), new Coordinate(15, 23), new Coordinate(33, 44));
        List<Coordinate> resultTwo = Lists.newArrayList();
        List<Coordinate> resultThree = Lists.newArrayList(new Coordinate(22, 66));

        if (locationSearchDto.getArrival().equals(new Coordinate(11, 22)) &&
                locationSearchDto.getDeparture().equals(new Coordinate(33, 44))) {
            return resultOne;
        }
        if (locationSearchDto.getArrival().equals(new Coordinate(23, 41)) &&
            locationSearchDto.getDeparture().equals(new Coordinate(50, 60))) {
            return resultTwo;
        }
        if (locationSearchDto.getArrival().equals(new Coordinate(22, 66)) &&
            locationSearchDto.getDeparture().equals(new Coordinate(22, 66))) {
            return resultThree;
        }
        return resultTwo;
    }

}
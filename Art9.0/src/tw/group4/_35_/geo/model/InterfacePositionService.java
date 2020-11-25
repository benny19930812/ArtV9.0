package tw.group4._35_.geo.model;

import java.util.List;

public interface InterfacePositionService {

	List<Position> getPositionBean();

	List<Position> getNoNullPositionBean();

	Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2);

	List<Position> setDistance(String userLocation);

	List<Activity> selectDistinctToAct();

	List<Position> recommendList();

	int[] produceRandomArray(int count);

}
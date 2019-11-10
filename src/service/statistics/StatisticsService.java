package service.statistics;

import java.util.HashMap;

public class StatisticsService implements IStatisticsService {
	HashMap<Integer, Integer> itemViewCounter;
	
	public StatisticsService() {
		itemViewCounter = new HashMap<Integer, Integer>();
	}

	@Override
	public void recordItemVisit(int itemId) {
		Integer cnt = itemViewCounter.get(itemId);
		if(cnt == null)
			cnt = 0;
		cnt++;
		itemViewCounter.put(itemId, cnt);
	}

	@Override
	public int getItemVisits(int itemId) {
		Integer cnt = itemViewCounter.get(itemId);
		if(cnt == null)
			cnt = 0;
		return cnt;
	}

	
}

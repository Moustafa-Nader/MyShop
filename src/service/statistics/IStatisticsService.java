package service.statistics;

public interface IStatisticsService {
	public void recordItemVisit(int itemId);
	public int getItemVisits(int itemId);
}

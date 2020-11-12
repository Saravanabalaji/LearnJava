package CinemaRoomManager;

public interface IStatistics {
    StatisticsData Generate(String[][] seats, PriceSetting priceSetting, RoomSetting roomSetting);
}



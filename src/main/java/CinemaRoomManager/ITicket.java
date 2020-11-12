package CinemaRoomManager;

public interface ITicket {
    int GetPrice(PriceSetting priceSetting, RoomSetting roomSetting, int selectedRow);
}

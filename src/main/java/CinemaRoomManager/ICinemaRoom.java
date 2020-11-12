package CinemaRoomManager;

public interface ICinemaRoom {
    RoomSetting Configure(int noOfRows, int noOfSeatsInEachRow, int smallRoomLimit);
}

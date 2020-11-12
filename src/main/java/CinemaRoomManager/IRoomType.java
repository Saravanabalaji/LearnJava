package CinemaRoomManager;

public interface IRoomType {
    Room Find(int noOfRows, int noOfSeatsInEachRow, int smallRoomLimit);
}
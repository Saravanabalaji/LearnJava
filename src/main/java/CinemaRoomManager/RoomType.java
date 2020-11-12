package CinemaRoomManager;

public class RoomType implements IRoomType
{
    @Override
    public Room Find(int noOfRows, int noOfSeatsInEachRow, int smallRoomLimit)
    {
        int totalSeats = noOfRows * noOfSeatsInEachRow;
        return totalSeats > smallRoomLimit ? Room.Large : Room.Small;
    }
}

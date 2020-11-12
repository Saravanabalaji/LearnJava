package CinemaRoomManager;

public class CinemaRoom implements ICinemaRoom
{
    private final IRoomType _roomType;
    private final ISeatingRow _seatingRow;

    public CinemaRoom()
    {
        _roomType = new RoomType();
        _seatingRow = new SeatingRow();
    }

    @Override
    public RoomSetting Configure(int noOfRows, int noOfSeatsInEachRow, int smallRoomLimit){
        Room room = _roomType.Find(noOfRows, noOfSeatsInEachRow, smallRoomLimit);
        var rowType = _seatingRow.Calculate(room, noOfRows);
        return new RoomSetting(room, rowType);
    }
}

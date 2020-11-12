package CinemaRoomManager;

public class RoomSetting {

    private final Room room;
    private final RowType rowType;

    public RoomSetting(Room room, RowType rowType)
    {
        this.room = room;
        this.rowType = rowType;
    }

    public Room getRoom() {
        return room;
    }
    public RowType getRowType() {
        return rowType;
    }
}

package CinemaRoomManager;

public interface ISeatingRow {
    RowType Calculate(Room room, int noOfRows);
}

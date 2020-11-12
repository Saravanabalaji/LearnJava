package CinemaRoomManager;

public interface ISeat {
    String[][] Build(int noOfRows, int noOfSeatsInEachRow);
    BookingResponse Book(int noOfRows, int noOfSeatsInEachRow, String[][] seats, int rowNumber, int selectedSeat);
}

package CinemaRoomManager;

public class Seat implements ISeat {
    @Override
    public String[][] Build(int noOfRows, int noOfSeatsInEachRow)
    {
        noOfRows++;
        noOfSeatsInEachRow++;

        String[][] seatArray = new String[noOfRows][noOfSeatsInEachRow];
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfSeatsInEachRow; j++) {
                seatArray[i][j] = i == 0 ? j == 0 ? " " : Integer.toString(j) : "S";
            }
        }

        for (int i = 0; i < noOfRows; i++) {
            seatArray[i][0] = i == 0 ? " " : Integer.toString(i);
        }
        return seatArray;
    }

    @Override
    public BookingResponse Book(int noOfRows, int noOfSeatsInEachRow, String[][] seats, int selectedRow, int selectedSeat)
    {
        BookingResponse bookingResponse = new BookingResponse();

        if (selectedRow > noOfRows || selectedSeat > noOfSeatsInEachRow || selectedRow ==0 || selectedSeat == 0) {
            bookingResponse.IsSuccessful = false;
            bookingResponse.Message = "Wrong input!";
        } else {
            switch (seats[selectedRow][selectedSeat]) {
                case "B":
                    bookingResponse.IsSuccessful = false;
                    bookingResponse.Message = "That ticket has already been purchased!";
                    break;
                default:
                    seats[selectedRow][selectedSeat] = "B";
                    bookingResponse.IsSuccessful = true;
                    break;
            }
        }
        bookingResponse.Seats = seats;
        return bookingResponse;
    }
}

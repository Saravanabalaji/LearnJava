package CinemaRoomManager;

public class SeatingRow implements ISeatingRow {
    @Override
    public RowType Calculate(Room room, int noOfRows) {
        int noOfOddRows = 0;
        int noOfEvenRows = 0;

        if (room == Room.Large) {
            for (int i = 1; i <= noOfRows; i++) {
                if (i % 2 == 0) {
                    noOfEvenRows++;
                } else {
                    noOfOddRows++;
                }
            }
        }
        var rowType = new RowType();
        rowType.setFrontRow(noOfEvenRows);
        rowType.setBackRow(noOfOddRows);

        return rowType;
    }
}

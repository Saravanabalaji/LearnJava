package CinemaRoomManager;

import java.util.Scanner;

public class Cinema {

    public static final int NORMAL_PRICE = 10;
    public static final int FRONT_ROW_PRICE = 10;
    public static final int BACK_ROW_PRICE = 8;
    public static final int SMALL_ROOM_LIMIT = 60;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int noOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int noOfSeatsInEachRow = scanner.nextInt();

        //Set the Pricing
        var priceSetting = new PriceSetting(NORMAL_PRICE, FRONT_ROW_PRICE, BACK_ROW_PRICE, SMALL_ROOM_LIMIT);

        // Configure Cinema Room
        ICinemaRoom cinemaRoom = new CinemaRoom();
        var roomSetting = cinemaRoom.Configure(noOfRows, noOfSeatsInEachRow, priceSetting.getSmallRoomLimit());

        // Build Seats in Room
        ISeat seat = new Seat();
        var seats = seat.Build(noOfRows, noOfSeatsInEachRow);

        while (true) {

            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println();

            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0:
                    return;
                case 1:
                    Display(seats);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int selectedRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int selectedSeat = scanner.nextInt();

                        var bookingResponse = seat.Book(noOfRows, noOfSeatsInEachRow, seats, selectedRow, selectedSeat);
                        seats = bookingResponse.Seats;
                        if (!bookingResponse.IsSuccessful) {
                            System.out.println(bookingResponse.Message);
                            System.out.println();
                        } else {
                            ITicket ticket = new Ticket();
                            int ticketPrice = ticket.GetPrice(priceSetting, roomSetting, selectedRow);
                            System.out.printf("Ticket price: $%d", ticketPrice);
                            break;
                        }
                    }
                    break;
                case 3:
                    IStatistics statistics = new Statistics();
                    var statisticsData = statistics.Generate(seats, priceSetting, roomSetting);

                    System.out.println();
                    System.out.printf("Number of purchased tickets: %d", statisticsData.PurchasedTickets);
                    System.out.println();
                    System.out.printf("Percentage: %.2f%%", statisticsData.PurchasedTicketPercent);
                    System.out.println();
                    System.out.printf("Current income: $%d", statisticsData.CurrentIncome);
                    System.out.println();
                    System.out.printf("Total income: $%d", statisticsData.TotalIncome);
                    System.out.println();
                    break;
            }
        }
    }

    private static void Display(String[][] seats) {
        System.out.println("Cinema:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}



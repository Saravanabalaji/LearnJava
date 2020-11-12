package CinemaRoomManager;

public class Statistics implements IStatistics {
    @Override
    public StatisticsData Generate(String[][] seats, PriceSetting priceSetting, RoomSetting roomSetting)
    {
        ITicket ticket = new Ticket();
        var purchasedTickets = 0;
        var totalTickets = 0;
        var currentIncome = 0;
        var totalIncome = 0;

        for (int i = 1; i < seats.length; i++) {
            var ticketPrice= ticket.GetPrice(priceSetting, roomSetting, i);
            for (int j = 1; j < seats[i].length; j++) {
                totalTickets++;
                totalIncome = totalIncome + ticketPrice;
                if(seats[i][j].equals("B"))
                {
                    purchasedTickets++;
                    currentIncome = currentIncome + ticketPrice;
                }
            }
        }

        float purchasePercent = (float) purchasedTickets / totalTickets;
        var statisticsData = new StatisticsData();
        statisticsData.CurrentIncome = currentIncome;
        statisticsData.TotalIncome = totalIncome;
        statisticsData.PurchasedTickets = purchasedTickets;
        statisticsData.PurchasedTicketPercent = purchasePercent;
        return statisticsData;
    }
}


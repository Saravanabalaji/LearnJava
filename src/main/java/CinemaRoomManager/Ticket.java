package CinemaRoomManager;

public class Ticket implements ITicket
{
    @Override
    public int GetPrice(PriceSetting priceSetting, RoomSetting roomSetting, int selectedRow)
    {
        var normalPrice = priceSetting.getNormalPrice();
        var frontRowPrice = priceSetting.getFrontRowPrice();
        var backRowPrice = priceSetting.getBackRowPrice();
        var frontRow = roomSetting.getRowType().getFrontRow();
        return !(roomSetting.getRoom() == Room.Large) ? normalPrice : selectedRow <= frontRow ? frontRowPrice : backRowPrice;
    }
}

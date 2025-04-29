package brainacad.entity;

import java.time.LocalDate;

public class Order
{
    private int id;
    private int clientId;
    private int staffId;
    private String itemType;
    private int itemId;
    private LocalDate orderDate;

    public Order(int id, int clientId, int staffId, String itemType, int itemId, LocalDate orderDate)
    {
        this.id = id;
        this.clientId = clientId;
        this.staffId = staffId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.orderDate = orderDate;
    }

    public int getId()
    {
        return id;
    }
    public int getClientId()
    {
        return clientId;
    }
    public int getStaffId()
    {
        return staffId;
    }
    public String getItemType()
    {
        return itemType;
    }
    public int getItemId()
    {
        return itemId;
    }
    public LocalDate getOrderDate()
    {
        return orderDate;
    }
}
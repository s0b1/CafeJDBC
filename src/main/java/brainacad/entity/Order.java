package brainacad.entity;

import java.time.LocalDate;

public class Order
{
    private int id;
    private int clientId;
    private int staffId;
    private String itemType; // "drink" or "dessert"
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

    public void setId(int id)
    {
        this.id = id;
    }

    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }

    public int getStaffId()
    {
        return staffId;
    }

    public void setStaffId(int staffId)
    {
        this.staffId = staffId;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public int getItemId()
    {
        return itemId;
    }

    public void setItemId(int itemId)
    {
        this.itemId = itemId;
    }

    public LocalDate getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate)
    {
        this.orderDate = orderDate;
    }

    @Override
    public String toString()
    {
        return "Order{id=" + id +
                ", clientId=" + clientId +
                ", staffId=" + staffId +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", orderDate=" + orderDate + '}';
    }
}
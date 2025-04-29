package brainacad.entity;

public class Staff
{
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String position; // "Barista", "Waiter", "Confectioner"

    public Staff() {}

    public Staff(String fullName, String phone, String email, String position)
    {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPosition()
    {
        return position;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    @Override
    public String toString()
    {
        return "Staff{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
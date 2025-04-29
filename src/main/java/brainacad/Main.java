package brainacad;

import brainacad.entity.Client;
import brainacad.entity.Drink;
import brainacad.entity.Staff;
import brainacad.entity.Order;
import brainacad.entity.Schedule;
import brainacad.jdbc.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            DrinkDAO drinkDAO = new DrinkDAO();
            ClientDAO clientDAO = new ClientDAO();
            StaffDAO staffDAO = new StaffDAO();
            OrderDAO orderDAO = new OrderDAO();
            ScheduleDAO scheduleDAO = new ScheduleDAO();

            System.out.println("INSERTING SAMPLE DATA");

//            Drink espresso = new Drink("Latte", "Латте", 2.50);
//            drinkDAO.addDrink(espresso);
//            System.out.println("Added drink: " + espresso.getNameEn());

            Client client = new Client("Tyler Callahan", LocalDate.of(1990, 3, 15), "555-1234", "tyty@example.com", 10.0);
//            clientDAO.addClient(client);
//            System.out.println("Added client: " + client.getFullName());

            Staff barista = new Staff("Alejandro Torres", "555-9999", "torres@cafe.com", "Barista");
//            staffDAO.addStaff(barista);
//            System.out.println("Added staff: " + barista.getFullName());

            orderDAO.addDrinkOrder(1, 4, 4, LocalDate.now());
            System.out.println("Added coffee order for client: " + client.getFullName());


            scheduleDAO.addSchedule(4, LocalDate.of(2025, 5, 1), LocalTime.of(9, 0), LocalTime.of(17, 0));
            System.out.println("Added schedule for staff: " + barista.getFullName());

            System.out.println("\nREADING ALL RECORDS");

            List<Drink> drinks = drinkDAO.getAllDrinks();
            System.out.println("Drinks:");
            drinks.forEach(System.out::println);

            List<Client> clients = clientDAO.getAllClients();
            System.out.println("\nClients:");
            clients.forEach(System.out::println);

            List<Staff> baristas = staffDAO.getStaffByPosition("Barista");
            System.out.println("\nBaristas:");
            baristas.forEach(System.out::println);

            List<Order> orders = orderDAO.getOrdersByClient(1);
            System.out.println("\nOrders for client " + client.getFullName() + ":");
            orders.forEach(System.out::println);

            List<Schedule> schedules = scheduleDAO.getScheduleByDate(LocalDate.of(2025, 5, 1));
            System.out.println("\nSchedules for May 1st, 2025:");
            schedules.forEach(System.out::println);

            orderDAO.updateOrder(1, 4, 5);
            System.out.println("\nUpdated order");

//            orderDAO.deleteOrderById(1);
//            System.out.println("\nDeleted order");

//            scheduleDAO.updateScheduleForDate(4, LocalDate.of(2025, 5, 1), LocalTime.of(10, 0), LocalTime.of(18, 0));
//            System.out.println("\nUpdated schedule for May 1st");
//
//            scheduleDAO.deleteScheduleByDate(LocalDate.of(2025, 5, 1));
//            System.out.println("\nDeleted schedule for May 1st");

        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
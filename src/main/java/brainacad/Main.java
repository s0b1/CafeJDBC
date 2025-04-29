package brainacad;

import brainacad.entity.Client;
import brainacad.entity.Drink;
import brainacad.entity.Staff;
import brainacad.jdbc.ClientDAO;
import brainacad.jdbc.DrinkDAO;
import brainacad.jdbc.StaffDAO;

import java.sql.SQLException;
import java.time.LocalDate;
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

            System.out.println(" INSERTING SAMPLE DATA ");

            Drink espresso = new Drink("Espresso", "Еспресо", 2.50);
            drinkDAO.addDrink(espresso);
            System.out.println("Added drink: " + espresso.getNameEn());

            Client client = new Client("Tyler Callahan", LocalDate.of(1990, 3, 15), "555-1234", "tyty@example.com", 10.0);
            clientDAO.addClient(client);
            System.out.println("Added client: " + client.getFullName());

            Staff barista = new Staff("Alejandro Torres", "555-9999", "torres@cafe.com", "Barista");
            staffDAO.addStaff(barista);
            System.out.println("Added staff: " + barista.getFullName());

            System.out.println("\n READING ALL RECORDS ");

            List<Drink> drinks = drinkDAO.getAllDrinks();
            System.out.println("Drinks:");
            drinks.forEach(System.out::println);

            List<Client> clients = clientDAO.getAllClients();
            System.out.println("\nClients:");
            clients.forEach(System.out::println);

            List<Staff> baristas = staffDAO.getStaffByPosition("Barista");
            System.out.println("\nBaristas:");
            baristas.forEach(System.out::println);

        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
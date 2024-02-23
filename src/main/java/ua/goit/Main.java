package ua.goit;

import org.hibernate.Session;
import ua.goit.client.Client;
import ua.goit.client.ClientCrudService;
import ua.goit.database.Database;
import ua.goit.database.DatabaseInitService;
import ua.goit.database.HibernateUtil;
import ua.goit.exceptions.IdOutOfRangeException;
import ua.goit.planet.Planet;
import ua.goit.planet.PlanetCrudService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IdOutOfRangeException {

        //Migration

        Database database = Database.getInstance();

        new DatabaseInitService().initDb(database);

        database.close();

        System.out.println("Migration");


        //ClIENT CRUD

        //Get client by id
        Client existingClient = new ClientCrudService().getClientById(9L);
        System.out.println("existingClient = " + existingClient);

        //Create new client
        long clientId = new ClientCrudService().createClient("Bruce Willis");
        System.out.println("newClient id = " + clientId);


        //Delete client
//        System.out.println("is deleted = " + new ClientCrudService().deleteClientById(3L));


        //PLANET CRUD

        //Get Panet by Id
        Planet existingPlanet = new PlanetCrudService().getPlanetById("PLUTO9");
        System.out.println("existingPlanet = " + existingPlanet);

        //Create new planet
/*        String planetId = new PlanetCrudService().createPlanet("REA20", "Reach");
        System.out.println("newPlanet Id = " + planetId);*/

        //Delete Planet
        System.out.println("is deleted = " + new PlanetCrudService().deletePlanetById("JUP5"));


    }
}
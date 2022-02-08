package view;

import controller.impl.*;
import model.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final LocationController locationController;
    private final CompanyController companyController;
    private final DriverController driverController;
    private final ManufacturerController manufacturerController;
    private final StopsController stopsController;
    private final RouteController routeController;
    private final BusController busController;

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View(){
        locationController = new LocationController();
        companyController = new CompanyController();
        driverController = new DriverController();
        manufacturerController = new ManufacturerController();
        stopsController = new StopsController();
        routeController = new RouteController();
        busController = new BusController();

        menu.put("11", this::getAllLocations);
        menu.put("12", this::getLocationById);
        menu.put("13", this::createLocation);
        menu.put("14", this::updateLocation);
        menu.put("15", this::deleteLocation);

        menu.put("21", this::getAllCompanies);
        menu.put("22", this::getCompanyById);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCompany);

        menu.put("31", this::getAllDrivers);
        menu.put("32", this::getDriverById);
        menu.put("33", this::createDriver);
        menu.put("34", this::updateDriver);
        menu.put("35", this ::deleteDriver);

        menu.put("41", this::getAllManufacturers);
        menu.put("42", this::getManufacturerById);
        menu.put("43", this::createManufacturer);
        menu.put("44", this::updateManufacturer);
        menu.put("45", this::deleteManufacturer);

        menu.put("51", this::getAllStops);
        menu.put("52", this::getStopsById);
        menu.put("53", this::createStops);
        menu.put("54", this::updateStops);
        menu.put("55", this::deleteStops);

        menu.put("61", this::getAllRoutes);
        menu.put("62",this::getRouteById );
        menu.put("63", this::createRoute);
        menu.put("64", this::updateRoute);
        menu.put("65", this::deleteRoute);

        menu.put("71", this::getAllBuses);
        menu.put("72", this::getBus);
        menu.put("73", this::createBus);
        menu.put("74", this::updateBus);
        menu.put("75", this::deleteBus);


    }
    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - location                     |         1 - GET ALL");
        System.out.println("  2 - company                      |         2 - GET ONE");
        System.out.println("  3 - driver                       |         3 - CREATE");
        System.out.println("  4 - manufacturer                 |         4 - UPDATE");
        System.out.println("  5 - stops                        |         5 - DELETE");
        System.out.println("  6 - route                        |                     ");
        System.out.println("  7 - bus                          |                     ");

        System.out.println("=======================================================================");
    }
    // --- LOCATIONS ---
    private void getAllLocations(){
        System.out.println("\n[LOCATION / GET]");
        System.out.println(locationController.findAll() + "\n");
    }
    private void getLocationById(){
        System.out.println("\n [LOCATION/ GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(locationController.findOne(id) + "\n");
    }
    private Location getLocationInputs(){
        System.out.println("\n Enter country name: ");
        String country = scanner.next();
        System.out.println("Enter city name: ");
        String city = scanner.next();
        System.out.println("\n Enter street name: ");
        String street = scanner.next();

        return new Location(0, country, city, street);
    }
    private void createLocation(){
        System.out.println("\n[LOCATION / CREATE]");
        Location location = getLocationInputs();
        locationController.create(location);
        System.out.println("Location successfully created\n");
    }
    private void updateLocation(){
        System.out.println("\n[LOCATION / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Location location = getLocationInputs();
        location.setId(id);
        locationController.update(location.getId(), location);

        System.out.println("Location with ID=" + id + " successfully updated");
    }
    private void deleteLocation(){
        System.out.println("[LOCATION/ DELETE] Enter ID: ");
        int id = scanner.nextInt();

        locationController.delete(id);
        System.out.println("Location with ID=" + id + " successfully deleted");
    }
    // --- COMPANIES ---
    private void getAllCompanies(){
        System.out.println("\n[COMPANY / GET]");
        System.out.println(companyController.findAll() + "\n");
    }
    private void getCompanyById(){
        System.out.println("\n [COMPANY / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(companyController.findOne(id) + "\n");
    }
    private Company getCompanyInputs(){
        System.out.println("\n Enter company name: ");
        String name = scanner.next();
        System.out.println("\n Enter location ID: ");
        Integer locationId = scanner.nextInt();
        Location location = locationController.findOne(locationId);

        return new Company(0,name, location);
    }
    private void createCountry(){
        System.out.println("\n[COMPANY/ CREATE]");
        Company company = getCompanyInputs();
        companyController.create(company);
        System.out.println("Company successfully created\n");
    }
    private void updateCountry(){
        System.out.println("\n[COMPANY/ UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Company company = getCompanyInputs();
        company.setId(id);
        companyController.update(company.getId(), company);

        System.out.println("Company with ID=" + id + " successfully updated");
    }
    private void deleteCompany(){
        System.out.println("[COMPANY / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        companyController.delete(id);
        System.out.println("Company with ID=" + id + " successfully deleted");
    }
    //  --- DRIVERS ---
    private void getAllDrivers(){
        System.out.println("\n[DRIVER / GET]");
        System.out.println(driverController.findAll() + "\n");
    }
    private void getDriverById(){
        System.out.println("\n [DRIVER / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(driverController.findOne(id) + "\n");
    }
    private Driver getDriverInputs(){
        System.out.println("\n Enter driver`s full name: ");
        String fullName = scanner.next();
        System.out.println("\n Enter driver`s age: ");
        Integer age= scanner.nextInt();
        System.out.println("\n Enter driver`s phone number : ");
        String phoneNumber = scanner.next();
        System.out.println("\n Enter driver`s email : ");
        String email = scanner.next();

        return new Driver(0, age, fullName,  phoneNumber, email );
    }
    private void createDriver(){
        System.out.println("\n[Driver / CREATE]");
        Driver driver = getDriverInputs();
        driverController.create(driver);
        System.out.println("Driver successfully created\n");
    }
    private void updateDriver(){
        System.out.println("\n[DRIVER / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Driver driver = getDriverInputs();
        driver.setId(id);
        driverController.update(driver.getId(), driver);

        System.out.println("Driver with ID=" + id + " successfully updated");
    }
    private void deleteDriver(){
        System.out.println("[DRIVER / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        driverController.delete(id);
        System.out.println("Driver with ID=" + id + " successfully deleted");
    }
    // --- MANUFACTURERS ---
    private void getAllManufacturers(){
        System.out.println("\n[MANUFACTURER / GET]");
        System.out.println(manufacturerController.findAll() + "\n");
    }
    private void getManufacturerById(){
        System.out.println("\n [MANUFACTURER / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(manufacturerController.findOne(id) + "\n");
    }

    private Manufacturer getManufacturerInputs(){
        System.out.println("\n Enter manufacturer name: ");
        String name = scanner.next();
        System.out.println("\n Enter location ID: ");
        Integer locationId = scanner.nextInt();
        Location location = locationController.findOne(locationId);

        return new Manufacturer(0, name, location);
    }
    private void createManufacturer(){
        System.out.println("\n[MANUFACTURER / CREATE]");
        Manufacturer manufacturer = getManufacturerInputs();
        manufacturerController.create(manufacturer);
        System.out.println("Manufacturer successfully created\n");
    }
    private void updateManufacturer(){
        System.out.println("\n[MANUFACTURER / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Manufacturer manufacturer = getManufacturerInputs();
        manufacturer.setId(id);
        manufacturerController.update(manufacturer.getId(), manufacturer);

        System.out.println("Manufacturer with ID=" + id + " successfully updated");
    }
    private void deleteManufacturer(){
        System.out.println("[MANUFACTURER / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        manufacturerController.delete(id);
        System.out.println("Manufacturer with ID=" + id + " successfully deleted");
    }
    // --- Stops ---
    private void getAllStops(){
        System.out.println("\n[STOPS / GET]");
        System.out.println(stopsController.findAll() + "\n");
    }
    private void getStopsById(){
        System.out.println("\n [STOPS / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(stopsController.findOne(id) + "\n");
    }
    private Stops getStopsInputs(){
        System.out.println("\n Enter stop`s name : ");
        String name = scanner.next();
        System.out.println("\n Enter stop`s bare price in EUR (relatively to previous one): ");
        Integer priceEUR = scanner.nextInt();
        System.out.println("\n Enter stop`s distance (relatively to previous one): ");
        Integer distanceKm = scanner.nextInt();
        System.out.println("\n Enter previous stop`s ID : ");
        Integer previousStopId = scanner.nextInt();
        System.out.println("\n Enter route ID: ");
        Integer routeId = scanner.nextInt();
        Route route = routeController.findOne(routeId);


        return new Stops(0, name, priceEUR, distanceKm, previousStopId, route);
    }
    private void createStops(){
        System.out.println("\n[STOPS / CREATE]");
        Stops stops = getStopsInputs();
        stopsController.create(stops);
        System.out.println("Stop successfully created\n");
    }
    private void updateStops(){
        System.out.println("\n[ STOPS / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Stops stops = getStopsInputs();
        stops.setId(id);
        stopsController.update(stops.getId(), stops);

        System.out.println("Stop with ID=" + id + " successfully updated");
    }
    private void deleteStops(){
        System.out.println("[STOPS / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        stopsController.delete(id);
        System.out.println("Stop with ID=" + id + " successfully deleted");
    }

    // --- ROUTE ---
    private void getAllRoutes(){
        System.out.println("\n[ROUTE / GET]");
        System.out.println(routeController.findAll() + "\n");
    }
    private void getRouteById(){
        System.out.println("\n [ROUTE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(routeController.findOne(id) + "\n");
    }
    private Route getRouteInputs(){
        System.out.println("\n Enter route`s start point: ");
        String startPoint = scanner.next();
        System.out.println("\n Enter route`s end point: ");
        String endPoint = scanner.next();
        System.out.println("\n Enter route`s price in EUR:");
        Integer routePriceInEUR = scanner.nextInt();
        System.out.println("\n Enter route`s length in km:");
        Integer lengthKm = scanner.nextInt();

        return new Route(0,startPoint, endPoint, routePriceInEUR, lengthKm);
    }

    private void createRoute(){
        System.out.println("\n[ROUTE / CREATE]");
        Route route = getRouteInputs();
        routeController.create(route);
        System.out.println("Route successfully created\n");
    }
    private void updateRoute(){
        System.out.println("\n[ROUTE / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Route route = getRouteInputs();
        route.setId(id);
        routeController.update(route.getId(), route);

        System.out.println("Route with ID=" + id + " successfully updated");
    }
    private void deleteRoute(){
        System.out.println("[ROUTE / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        routeController.delete(id);
        System.out.println("Route with ID=" + id + " successfully deleted");
    }

    // --- BUSES ---
    private void getAllBuses(){
        System.out.println("\n[BUS / GET]");
        System.out.println(busController.findAll() + "\n");
    }
    private void getBus(){
        System.out.println("\n [BUS / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(busController.findOne(id) + "\n");
    }

    private Bus getBusInputs(){
        System.out.println("\n Enter bus number: ");
        String busNumber = scanner.next();
        System.out.println("\n Enter bus mileage in km:");
        Integer mileageKm = scanner.nextInt();
        System.out.println("\n Enter bus age:");
        Integer age = scanner.nextInt();
        System.out.println("\n Enter bus seats number:");
        Integer seats = scanner.nextInt();
        System.out.println("\n Enter route ID: ");
        Integer idRoute = scanner.nextInt();
        Route route = routeController.findOne(idRoute);
        System.out.println("\n Enter owner company ID: ");
        Integer ownerCompanyId = scanner.nextInt();
        Company company = companyController.findOne(ownerCompanyId);
        System.out.println("\n Enter manufacturer ID: ");
        Integer manufacturerId = scanner.nextInt();
        Manufacturer manufacturer = manufacturerController.findOne(manufacturerId);

        return new Bus(0,busNumber, mileageKm, age, seats, route, company, manufacturer);
    }
    private void createBus(){
        System.out.println("\n[BUS / CREATE]");
        Bus bus = getBusInputs();
        busController.create(bus);
        System.out.println("Bus successfully created\n");
    }
    private void updateBus(){
        System.out.println("\n[BUS / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Bus bus = getBusInputs();
        bus.setId(id);
        busController.update(bus.getId(), bus);

        System.out.println("Bus with ID=" + id + " successfully updated");
    }
    private void deleteBus(){
        System.out.println("[BUS / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        busController.delete(id);
        System.out.println("Bus with ID=" + id + " successfully deleted");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your fighter:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }
}
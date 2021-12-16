package ua.lviv.iot.view;


import org.apache.velocity.runtime.directive.Stop;
import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.entity.bus.*;
import ua.lviv.iot.model.entity.driver.Driver;
import ua.lviv.iot.model.entity.route.Route;
import ua.lviv.iot.model.entity.route.Stops;

import java.util.Scanner;

public class View {
    private static final String ERROR_INVALID_KEY_INPUT = ViewOperations.ERROR_INVALID_KEY_INPUT;
    private static final String EXIT_KEY = ViewOperations.EXIT_KEY;
    private static final String BUS_KEY = "0";
    private static final String DRIVER_KEY = "1";
    private static final String MANUFACTURER_KEY = "2";
    private static final String COMPANY_KEY = "3";
    private static final String ROUTE_KEY = "4";
    private static final String STOPS_KEY = "5";
    private static final String LOCATION_KEY = "6";
    private static final String GET_ALL_KEY = "0";
    private static final String GET_BY_ID_KEY = "1";
    private static final String UPDATE_KEY = "2";
    private static final String CREATE_KEY = "3";
    private static final String DELETE_KEY = "4";
    static Scanner input = new Scanner(System.in);

    private static void printSeparator() {
        System.out.println("--------------------------------------");
    }

    private static String printMainMenu() {
        System.out.println("Choose table to work with:");
        System.out.println(BUS_KEY + "-" + "Bus");
        System.out.println(DRIVER_KEY + "-" + "Driver");
        System.out.println(MANUFACTURER_KEY + "-" + "Manufacturer");
        System.out.println(COMPANY_KEY + "-" + "Company");
        System.out.println(ROUTE_KEY + "-" + "Route");
        System.out.println(STOPS_KEY + "-" + "Stops");
        System.out.println(LOCATION_KEY + "-" + "Location");
        System.out.println(EXIT_KEY + "-" + "Exit");
        return input.nextLine().toUpperCase();
    }

    private static String printTableMenu() {
        System.out.println("Choose what to do");
        System.out.println(GET_ALL_KEY + "-" + "Get all rows");
        System.out.println(GET_BY_ID_KEY + "-" + "Get row by id");
        System.out.println(UPDATE_KEY + "-" + "Update row");
        System.out.println(CREATE_KEY + "-" + "Create row");
        System.out.println(DELETE_KEY + "-" + "Delete row");
        System.out.println(EXIT_KEY + "-" + "Return to main menu");
        return input.nextLine().toUpperCase();
    }

    public static void execute() {

        main_label:
        while (true) {
            Class currentClass;
            AbstractControllerImpl controller;
            ViewOperations viewOperations;

            String mainMenuInput = printMainMenu();
            switch (mainMenuInput) {
                case BUS_KEY:
                    currentClass = Bus.class;
                    controller = new BusControllerImpl();
                    break;
                case DRIVER_KEY:
                    currentClass = Driver.class;
                    controller = new DriverControllerImpl();
                    break;
                case MANUFACTURER_KEY:
                    currentClass = Manufacturer.class;
                    controller = new ManufacturerControllerImpl();
                    break;
                case COMPANY_KEY:
                    currentClass = Company.class;
                    controller = new CompanyControllerImpl();
                    break;
                case ROUTE_KEY:
                    currentClass = Route.class;
                    controller = new RouteControllerImpl();
                    break;
                case STOPS_KEY:
                    currentClass = Stops.class;
                    controller = new StopsControllerImpl();
                    break;
                case LOCATION_KEY:
                    currentClass = Location.class;
                    controller = new LocationControllerImpl();
                    break;
                case EXIT_KEY:
                    break main_label;
                default:
                    System.out.println(ERROR_INVALID_KEY_INPUT);
                    continue;
            }
            printSeparator();
            viewOperations = new ViewOperations(controller, currentClass);
            table_label:
            while (true) {
                System.out.println("You are working with " + currentClass.getSimpleName() + " table");
                String tableMenuInput = printTableMenu();
                printSeparator();
                switch (tableMenuInput) {
                    case GET_ALL_KEY:
                        viewOperations.getAll();
                        break;
                    case GET_BY_ID_KEY:
                        viewOperations.get();
                        break;
                    case UPDATE_KEY:
                        viewOperations.update();
                        break;
                    case CREATE_KEY:
                        viewOperations.create();
                        break;
                    case DELETE_KEY:
                        viewOperations.delete();
                        break;
                    case EXIT_KEY:
                        break table_label;
                    default:
                        System.out.println(ERROR_INVALID_KEY_INPUT);
                }
                printSeparator();
            }
        }
    }
}

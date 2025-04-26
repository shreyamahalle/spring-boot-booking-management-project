package com.shreya.spring;

import com.shreya.spring.exception.InvalideCustomerIDException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootBookingManagementProjectApplication {

    public static void main(String[] args) throws InvalideCustomerIDException, SQLException {

        SpringApplication.run(SpringBootBookingManagementProjectApplication.class, args);

    }
}


//        final ConnectionService connectionService = new ConnectionService();
//        final Scanner sc = new Scanner(System.in);
//        int option = 0;
//        do {
//            System.out.println("-----------Booking Management-----------");
//            System.out.println("Please choose the option");
//            System.out.println("1. Create customer");
//            System.out.println("2. Create delivery agent");
//            System.out.println("3. Create order");
//            System.out.println("4. Create restaurant ");
//            System.out.println("5. Display Order Number");
//            System.out.println("6. Combo Pack Offer");
//            System.out.println("0. Exit project");
//            System.out.println("Select the option..");
//            option = Integer.parseInt(sc.nextLine());
//
//            switch (option) {
//                case 1:
//                    CustomerController controller = context.getBean(CustomerController.class); // correct
//                    break;
//            }
//            switch (option) {
//                case 2:
//                    DeliveryAgentController deliveryAgentController = context.getBean(DeliveryAgentController.class);
//                    break;
//            }
//            switch (option) {
//                case 3:
//                    OrderController orderController = context.getBean(OrderController.class);
//                    break;
//            }
//            switch (option) {
//                case 4:
//                    RestaurantController restaurantController = context.getBean(RestaurantController.class);
//                    break;
//            }
//            switch (option) {
//                case 5:
//                    OrderNumberService orderNumberService = new OrderNumberImpl();
//                    CustomerImpl customerImpl = new CustomerImpl();
//                    OrderNumberController orderNumberController = new OrderNumberController();
//                    orderNumberController.run();
//                    orderNumberService.createOrderNo();
//                    customerImpl.printCustomer();
//                    customerImpl.createOrder();
//            }
//            switch (option) {
//                case 6:
//                    OrderMultipleInheritanceService orderMultipleInheritanceService = new OrderMultipleInheritanceService();
//                    orderMultipleInheritanceService.displayOrder();
//            }
//            switch (option) {
//                case 0:
//                    System.out.println("Exiting project");
//                    break;
//            }
//        }
//        while (option != 0);
//
//        System.out.println("THANK YOU!");
//    }
//}

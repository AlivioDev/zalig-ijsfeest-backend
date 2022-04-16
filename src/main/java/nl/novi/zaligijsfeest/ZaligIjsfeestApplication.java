package nl.novi.zaligijsfeest;

import nl.novi.zaligijsfeest.dto.*;
import nl.novi.zaligijsfeest.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZaligIjsfeestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaligIjsfeestApplication.class, args);
    }

    @Bean
    CommandLineRunner runProducts(ProductService productService) {
        return args -> {
            productService.addProduct(new ProductDto(1001L, "Jstaart Rond", "4/6 personen", "8/10 personen", "14/16 personen", 20.00, 26.50, 39.00));
            productService.addProduct(new ProductDto(1002L, "IJstaart Kerstster", "5/6 personen", "0/12 personen", 25.00, 35.00));
            productService.addProduct(new ProductDto(1003L, "IJstaart Kerstklok", "5/6 personen", "14/16 personen", 25.00, 39.00));
            productService.addProduct(new ProductDto(1004L, "Cassata", "8/10 personen", 32.50));
            productService.addProduct(new ProductDto(1005L, "Tulband", "8/10 personen", 32.50));
            productService.addProduct(new ProductDto(1006L, "Kerstkathedraal", "8/10 personen", 35.00));
            productService.addProduct(new ProductDto(1007L, "Bombe", "3/4 personen", 19.50));
            productService.addProduct(new ProductDto(1008L, "Profiterolles", "Vanaf 6 personen", 5.00));
        };
    }

    @Bean
    CommandLineRunner runIceCream(IceCreamFlavorService iceCreamFlavorService) {
        return args -> {
            iceCreamFlavorService.addFlavor(new FlavorDto("Aardbei"));
            iceCreamFlavorService.addFlavor(new FlavorDto("banaan"));
            iceCreamFlavorService.addFlavor(new FlavorDto("roomijs"));
            iceCreamFlavorService.addFlavor(new FlavorDto("amarena"));
            iceCreamFlavorService.addFlavor(new FlavorDto("lemon cheesecake"));
            iceCreamFlavorService.addFlavor(new FlavorDto("bosbessenyoghurt"));
            iceCreamFlavorService.addFlavor(new FlavorDto("yoghurt"));
            iceCreamFlavorService.addFlavor(new FlavorDto("yoghurt passievrucht"));
            iceCreamFlavorService.addFlavor(new FlavorDto("zuppa inglese"));
            iceCreamFlavorService.addFlavor(new FlavorDto("mokka"));
            iceCreamFlavorService.addFlavor(new FlavorDto("brownies"));
            iceCreamFlavorService.addFlavor(new FlavorDto("biscotti"));
            iceCreamFlavorService.addFlavor(new FlavorDto("stracciatella"));
            iceCreamFlavorService.addFlavor(new FlavorDto("soescholato"));
            iceCreamFlavorService.addFlavor(new FlavorDto("tiramisu"));
            iceCreamFlavorService.addFlavor(new FlavorDto("black cookies"));
            iceCreamFlavorService.addFlavor(new FlavorDto("bianco d'Oro"));
            iceCreamFlavorService.addFlavor(new FlavorDto("hazelnoot"));
            iceCreamFlavorService.addFlavor(new FlavorDto("pralinone"));
            iceCreamFlavorService.addFlavor(new FlavorDto("pistache"));
            iceCreamFlavorService.addFlavor(new FlavorDto("malaga"));
            iceCreamFlavorService.addFlavor(new FlavorDto("kaneel"));
            iceCreamFlavorService.addFlavor(new FlavorDto("butterscotch"));
            iceCreamFlavorService.addFlavor(new FlavorDto("stroopwafel"));
            iceCreamFlavorService.addFlavor(new FlavorDto("salted caramel"));
        };
    }

    @Bean
    CommandLineRunner runSorbet(SorbetFlavorService sorbetFlavorService) {
        return args -> {
            sorbetFlavorService.addFlavor(new FlavorDto("meloen"));
            sorbetFlavorService.addFlavor(new FlavorDto("citroen"));
            sorbetFlavorService.addFlavor(new FlavorDto("sinaasappel"));
            sorbetFlavorService.addFlavor(new FlavorDto("mango"));
            sorbetFlavorService.addFlavor(new FlavorDto("cassis"));
            sorbetFlavorService.addFlavor(new FlavorDto("rode guave"));
            sorbetFlavorService.addFlavor(new FlavorDto("appel"));
            sorbetFlavorService.addFlavor(new FlavorDto("framboos"));
        };
    }

    @Bean
    CommandLineRunner runUsers(UserService userService) {
        return args -> {

            userService.addUser(new UserDto("user", "user@test.nl", "user", "testklant", "1234", "012-3456789", "USER"));

        };
    }

    @Bean
    CommandLineRunner runAdmins(AdminService adminService) {
        return args -> {
            adminService.addAdmin(new AdminDto("admin", "admin@test.nl", "1234", "ADMIN"));
        };
    }

    @Bean
    CommandLineRunner runOrders(OrderService orderService) {
        return args -> {
          orderService.addOrder(new OrderDto(1100L, "Kerstster, 4/6 personen, banaan, aardbei", 45.00, "24-12-2022 12:30", true));
        };
    }
}

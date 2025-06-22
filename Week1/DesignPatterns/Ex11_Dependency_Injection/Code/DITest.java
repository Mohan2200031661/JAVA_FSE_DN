package dependencyInjection;

public class DITest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl(); 
        CustomerService service = new CustomerService(repository);

        service.displayCustomer(1);
        service.displayCustomer(2);
    }
}


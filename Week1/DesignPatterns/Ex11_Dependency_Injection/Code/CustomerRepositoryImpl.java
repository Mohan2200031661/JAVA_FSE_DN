package dependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        if (id == 1) {
            return new Customer(1, "Rohit Mehta");
        } else {
            return new Customer(id, "Unknown Customer");
        }
    }
}


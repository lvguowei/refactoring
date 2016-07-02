
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Lv guowei");
        Movie deadpool2= new Movie("Deadpool2", Movie.NEW_RELEASE);
        Rental rental = new Rental(deadpool2, 4);
        customer.addRental(rental);
        System.out.print(customer.statement());
    }
}

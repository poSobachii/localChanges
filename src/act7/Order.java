package act7;

public class Order implements Comparable<Order> {
    private static final int POSITIVE = 1;
    private static final int NEGATIVE = -1;

    String customer;
    String name;
    int count;

    public Order(String customer, String name, Integer count) {
        this.customer = customer;
        this.name = name;
        this.count = count;
    }

    @Override
    public int compareTo(Order o) {
        int status;

        status = normalizeStatus(name.compareTo(o.name));
        if (status == 0) {
            status = normalizeStatus(customer.compareTo(o.customer));
            if (status == 0) {
                return normalizeStatus(((Integer) count).compareTo(o.count));
            }
        }

        return status;
    }

    private int normalizeStatus(int status) {
        if (status > 0) {
            return POSITIVE;
        } else if (status < 0) {
            return NEGATIVE;
        } else
            return status;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Order && compareTo((Order) obj) == 0;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return name + ": " + customer + ": " + count;
    }

}

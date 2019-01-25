package x006act6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Orders implements Iterator<Order> {
    private List<Order> orders;
    Iterator<Order> iterator;

    private class ItemOrders {
        private String itemName;
        private ArrayList<String> customerList;
        private int count;

        private ItemOrders(String itemName, String customer, int count) {
            this.itemName = itemName;
            this.customerList = new ArrayList<>();
            customerList.add(customer);
            this.count = count;
        }

        private void addCount(int increase) {
            count += increase;
        }

        private void addCustomer(String customer) {
            customerList.add(customer);
        }

        private String getSortedCustomerList() {
            Collections.sort(customerList);
            StringBuilder customers = new StringBuilder();
            for (int i = 0; i < customerList.size(); i++) {
                customers.append(customerList.get(i));
                if(i<customerList.size()-1){
                    customers.append(",");
                }
            }
            return new String(customers);
        }

    }

    public Orders() {
        orders = new LinkedList<>();
        iterator = orders.iterator();
    }

    public void add(Order item) {
        orders.add(item);
        iterator = orders.iterator();
    }

    public List<Order> getItemsList() {
        return orders;
    }

    private Set<Order> aggregateItemOrders(List<Order> sortedOrders) {
        Set<Order> result = new TreeSet<>();

        List<ItemOrders> itemOrdersList = new LinkedList<>();

        String prevItemName = null;
        ItemOrders currItemOrders = null;
        for (Order o : sortedOrders) {
            String currItemName = o.name;
            if (!currItemName.equals(prevItemName)) {
                prevItemName = currItemName;
                currItemOrders = new ItemOrders(currItemName, o.customer, o.count);
                itemOrdersList.add(currItemOrders);
            } else {
                currItemOrders.addCustomer(o.customer);
                currItemOrders.addCount(o.count);
            }

        }

        for (ItemOrders itemOrders : itemOrdersList) {
            result.add(new Order(itemOrders.getSortedCustomerList(), itemOrders.itemName, itemOrders.count));
        }
        return result;
    }

    public Set<Order> getItemsSet() {

        List<Order> tempItemOrders = new LinkedList<>(orders);
        if (orders.size() != 0) {
            Collections.sort(tempItemOrders);
            return aggregateItemOrders(orders);
        } else {
            return new LinkedHashSet<>();
        }
    }

    public void sort() {
        Collections.sort(orders);
    }

    public void remove() {
        iterator.remove();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Order next() {
        return iterator.next();
    }

    @Override
    public String toString() {
        return orders.toString();
    }

}

package com.loggar.list.search;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FindElementFromList {
    List<Customer> customers;
    Customer james = new Customer(2, "James");

    @BeforeEach
    void beforeEach() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "James"));
        customers.add(new Customer(3, "Kelly"));
    }

    @Test
    public void javaPlain_contains() {
        assertTrue(customers.contains(james));
    }

    @Test
    public void javaPlain_indexOf() {
        assertTrue(customers.indexOf(james) > -1);
    }

    Customer findUsingLooping(Customer c, List<Customer> customers) {
        for (Customer customer : customers) {
            if (
                customer.getName()
                        .equals(c.getName())
            ) {
                return customer;
            }
        }
        return null;
    }

    @Test
    public void javaPlain_looping() {
        assertTrue(findUsingLooping(james, customers).equals(james));
    }

    Customer findUsingIterator(Customer c, List<Customer> customers) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (
                customer.getName()
                        .equals(c.getName())
            ) {
                return customer;
            }
        }
        return null;
    }

    @Test
    public void javaPlain_iterating() {
        assertTrue(findUsingIterator(james, customers).equals(james));
    }

    @Test
    public void java8_streamAPI() {
        Customer c = customers.stream()
                .filter(
                        customer -> james.getName()
                                .equals(customer.getName())
                )
                .findAny()
                .orElse(null);

        assertTrue(c.equals(james));
    }

    @Test
    public void guava1() {
        Customer c = Iterables.tryFind(customers, new Predicate<Customer>() {
            public boolean apply(Customer customer) {
                return james.getName()
                        .equals(customer.getName());
            }
        })
                .orNull();

        assertTrue(c.equals(james));
    }

    @Test
    public void guava2() {
        Customer c = Iterables.tryFind(customers, new Predicate<Customer>() {
            public boolean apply(Customer customer) {
                return james.getName()
                        .equals(customer.getName());
            }
        })
                .or(customers.get(0));

        assertTrue(c.equals(james));
    }

    public class Customer {

        private int id;
        private String name;

        public Customer(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Customer other = (Customer) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance())) return false;
            if (id != other.id) return false;
            if (name == null) {
                if (other.name != null) return false;
            } else if (!name.equals(other.name)) return false;
            return true;
        }

        private FindElementFromList getEnclosingInstance() {
            return FindElementFromList.this;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Customer [id=")
                    .append(id)
                    .append(", name=")
                    .append(name)
                    .append("]");
            return builder.toString();
        }

    }
}

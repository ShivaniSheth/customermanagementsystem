package com.example.demo.service;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
//    private int customerIdCount=1;
//    private List<Customer> customerList=new CopyOnWriteArrayList<>();
    //customer list which holds customer objects

    //adding customer to customerList
    public Customer addCustomer(Customer customer)
    {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
        return customerDao.save(customer);
    }
    //retrieve list of customers
    public List<Customer> getCustomers()
    {
        return customerDao.findAll();
//        return customerList;
    }
    //retrieve specific customers
    public Customer getCustomer(int customerId)

    {
        return customerDao.findById(customerId).get();
      //return customerList.stream().filter(c ->c.getCustomerId()==customerId).findFirst().get();
    }

    public Customer updateCustomer(int customerId,Customer customer)
    {
        customer.setCustomerId(customerId);
//        customerList.stream().forEach(c->{
//            if(c.getCustomerId()==customerId){
//                c.setCustomerFirstName(customer.getCustomerFirstName());
//                c.setCustomerLastName(customer.getCustomerLastName());
//                c.setCustomerEmail(customer.getCustomerEmail());
//
//            }
//        });
//        return customerList.stream().filter(c->c.getCustomerId()==customerId).findFirst().get();

        return customerDao.save(customer);
    }
    public void deleteCustomer(int customerId){
//        customerList.stream().forEach(c->{
//            if(c.getCustomerId()==customerId){
//                customerList.remove(c);
//            }
//        });
        customerDao.deleteById(customerId);
    }

}

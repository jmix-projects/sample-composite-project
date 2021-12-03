package com.company.customers.screen.customer;

import io.jmix.ui.screen.*;
import com.company.customers.entity.Customer;

@UiController("cst_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
public class CustomerBrowse extends StandardLookup<Customer> {
}
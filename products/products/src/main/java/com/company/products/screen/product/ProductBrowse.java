package com.company.products.screen.product;

import io.jmix.ui.screen.*;
import com.company.products.entity.Product;

@UiController("prd_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
public class ProductBrowse extends StandardLookup<Product> {
}
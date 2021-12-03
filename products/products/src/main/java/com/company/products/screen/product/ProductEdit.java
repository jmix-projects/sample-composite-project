package com.company.products.screen.product;

import io.jmix.ui.screen.*;
import com.company.products.entity.Product;

@UiController("prd_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
public class ProductEdit extends StandardEditor<Product> {
}
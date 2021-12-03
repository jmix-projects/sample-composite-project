package com.company.sales.screen.orderline;

import io.jmix.ui.screen.*;
import com.company.sales.entity.OrderLine;

@UiController("OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineDc")
public class OrderLineEdit extends StandardEditor<OrderLine> {
}
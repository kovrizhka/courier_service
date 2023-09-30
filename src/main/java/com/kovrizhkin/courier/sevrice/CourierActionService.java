package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.Order;

public interface CourierActionService {

    void toLate(Order order);
}

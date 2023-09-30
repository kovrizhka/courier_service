package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.Order;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;

public class CourierActionServiceImpl implements CourierActionService{

    private final CallCenterTaskRepository callCenterTaskRepository = new CallCenterTaskRepository();

    @Override
    public void toLate(Order order) {
        callCenterTaskRepository.getCallCenterTasks().add(new CallCenterTask(order.getOrderNumber()));
    }
}

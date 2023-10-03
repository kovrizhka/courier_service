package com.kovrizhkin.courier;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.Order;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;
import com.kovrizhkin.courier.sevrice.CallCenterActionService;
import com.kovrizhkin.courier.sevrice.CallCenterActionServiceImpl;
import com.kovrizhkin.courier.sevrice.CourierActionService;
import com.kovrizhkin.courier.sevrice.CourierActionServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CourierActionServiceImpl courierActionServiceService = new CourierActionServiceImpl();
        CallCenterActionServiceImpl callCenterActionService = new CallCenterActionServiceImpl();


        courierActionServiceService.toLate(new Order(12));
        courierActionServiceService.toLate(new Order(15));
        courierActionServiceService.toLate(new Order(16));
        courierActionServiceService.toLate(new Order(18));
        courierActionServiceService.toLate(new Order(69));

        System.out.println(callCenterActionService.getTasksToCall());


        callCenterActionService.saveCallResult(1, TaskStatus.DONE, "Клиент оповещен");
        callCenterActionService.saveCallResult(4, TaskStatus.DONE, "Клиент оповещен");

        System.out.println("__________________________");
        System.out.println(callCenterActionService.getTasksToCall());
        System.out.println("________SORTING___________");
        System.out.println(callCenterActionService.getTasksToCall("2023-04-23", "2023-10-02", null, null));








    }
}
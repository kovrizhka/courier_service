package com.kovrizhkin.courier;

import com.kovrizhkin.courier.entity.Order;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.sevrice.CallCenterActionServiceImpl;
import com.kovrizhkin.courier.sevrice.CourierActionServiceImpl;


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









    }
}
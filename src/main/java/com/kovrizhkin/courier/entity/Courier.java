package com.kovrizhkin.courier.entity;

import com.kovrizhkin.courier.CourierAction;
import com.kovrizhkin.courier.CourierMessage;

import java.util.ArrayList;
import java.util.List;

public class Courier implements CourierAction {

    CallCenterTaskBoard taskBoard = new CallCenterTaskBoard();

    List<Order> ordersList = new ArrayList<>();

    public Order getOrder() {
        return ordersList.get((int) (0 + ordersList.size() * Math.random()));
    }


    public Courier(ArrayList<Order> newOrders) {
        this.ordersList = newOrders;
    }


    @Override
    public void toLate() {
        taskBoard.getTaskBoard().add(taskBoard.getTaskBoard().size(), new CallCenterTask(this.getOrder().getOrderNumber(), CourierMessage.LATE)) ;
    }
}

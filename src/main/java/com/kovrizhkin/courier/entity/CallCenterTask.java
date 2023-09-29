package com.kovrizhkin.courier.entity;


import com.kovrizhkin.courier.CourierMessage;

import java.time.Instant;


public class CallCenterTask {

    CallCenterTaskBoard taskBoard = new CallCenterTaskBoard();

    private int taskId;

    private int orderNumber;

    private Instant taskDate;

    private CourierMessage courierMessage;

    private boolean taskIsDone;


    public CallCenterTask(int orderNumber, CourierMessage courierMessage) {
        this.taskId = taskBoard.getTaskBoard().size();
        this.orderNumber = orderNumber;
        this.taskDate = Instant.now();
        this.courierMessage = courierMessage;
        this.taskIsDone = false;
    }

    //GETTERS
    public int getTaskId() {
        return taskId;
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public Instant getTaskDate() {
        return taskDate;
    }

    public boolean isTaskIsDone() {
        return taskIsDone;
    }


    //SETTERS
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }
}

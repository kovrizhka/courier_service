package com.kovrizhkin.courier.entity;


import com.kovrizhkin.courier.CourierMessage;
import com.kovrizhkin.courier.UniqueIdGeneratorForTask;

import java.time.Instant;


public class CallCenterTask {

    Order order;

    private int taskId;

    private Instant taskDate;

    private CourierMessage courierMessage;

    private boolean taskIsDoneStatus;




    public CallCenterTask(Order order, CourierMessage courierMessage) {
        this.taskId = UniqueIdGeneratorForTask.getNextId();
        this.order = order;
        this.taskDate = Instant.now();
        this.courierMessage = courierMessage;
        this.taskIsDoneStatus = false;
    }

    //GETTERS
    public int getTaskId() {
        return taskId;
    }
    public int getOrderNumber() {
        return order.getOrderNumber();
    }

    public Instant getTaskDate() {
        return taskDate;
    }

    public boolean isTaskIsDone() {
        return taskIsDoneStatus;
    }


    //SETTERS
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskIsDoneStatus(boolean taskIsDone) {
        this.taskIsDoneStatus = taskIsDone;
    }
}

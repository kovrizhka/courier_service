package com.kovrizhkin.courier.entity;


import com.kovrizhkin.courier.entity.type.TaskStatus;

import java.time.Instant;


public class CallCenterTask {


    private int orderNumber;

    private int taskId;

    private final Instant taskDate;

    private TaskStatus taskStatus;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String comment;



    public CallCenterTask(int orderNumber) {
        this.orderNumber = orderNumber;
        this.taskId = UniqueIdGeneratorForTask.getNextId();
        this.taskDate = Instant.now();
        this.taskStatus = TaskStatus.NOT_DONE;
        this.comment = "";
    }

    @Override
    public String toString() {
        return "ID задания: " + this.taskId + "\n"
                +"Номер заказа: " + this.orderNumber + "\n"
                + "Статус: " + this.taskStatus + "\n"
                + "Комментарий: " + this.comment + "\n";
    }

    public int getTaskId() {
        return taskId;
    }

    public Instant getTaskDate() {
        return taskDate;
    }

    public TaskStatus isTaskIsDone() {
        return taskStatus;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public TaskStatus getTaskIsDoneStatus() {
        return taskStatus;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
}

    public void setTaskStatus(TaskStatus taskIsDone) {
        this.taskStatus = taskIsDone;
    }
}

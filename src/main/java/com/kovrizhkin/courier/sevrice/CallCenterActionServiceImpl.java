package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CallCenterActionServiceImpl implements CallCenterActionService {

    private final CallCenterTaskRepository callCenterTaskRepository = new CallCenterTaskRepository();

    @Override
    public List<CallCenterTask> getTasksToCall() {
        List<CallCenterTask> tasks = callCenterTaskRepository.getCallCenterTasks();
        return tasks;
    }

    //сортировка по дате
    public List<CallCenterTask> getTasksToCall(String from_yyyy_MM_dd, String to_yyyy_MM_dd, Integer ordersNumber, TaskStatus ordersStatus) {
        Integer orderNumber = ordersNumber;
        TaskStatus taskStatus = ordersStatus;
        LocalDateTime fromLocalDateTime = LocalDateTime.parse(from_yyyy_MM_dd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime toLocalDateTime = LocalDateTime.parse(to_yyyy_MM_dd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Instant fromDate = fromLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Instant toDate = toLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();

        List<CallCenterTask> tasks = callCenterTaskRepository.getCallCenterTasks().stream()
                .filter(task -> task.getTaskDate().isAfter(fromDate) && task.getTaskDate().isBefore(toDate)
                    || task.getTaskDate().equals(fromDate) || task.getTaskDate().equals(toDate))
                .filter(task -> {
                    if (ordersNumber == null) {
                        return false;
                    }
                    return task.getOrderNumber() == ordersNumber;
                })
                .filter(task -> {
                    if (taskStatus == null) {
                        return false;
                    }
                    return task.isTaskIsDone() == taskStatus;
                })
                .collect(Collectors.toList());
    return tasks;
    }

    @Override
    public void saveCallResult(int taskId, TaskStatus taskStatus, String taskComment) {
        for(CallCenterTask task: callCenterTaskRepository.getCallCenterTasks()) {
            if(task.getTaskId() == taskId) {
                task.setTaskStatus(taskStatus);
                task.setComment(taskComment);
            }
        }
    }
}

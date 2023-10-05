package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;

import java.time.Instant;
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
    public List<CallCenterTask> getTasksToCall(Instant fromDate, Instant toDate, Integer ordersNumber, TaskStatus taskStatus) {

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

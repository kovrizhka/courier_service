package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;

import java.util.List;

public class CallCenterActionServiceImpl implements CallCenterActionService {

    private final CallCenterTaskRepository callCenterTaskRepository = new CallCenterTaskRepository();

    @Override
    public List<CallCenterTask> getTasksToCall() {
        List<CallCenterTask> tasks = callCenterTaskRepository.getCallCenterTasks();

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

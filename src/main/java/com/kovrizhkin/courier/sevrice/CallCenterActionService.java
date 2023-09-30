package com.kovrizhkin.courier.sevrice;

import com.kovrizhkin.courier.entity.CallCenterTask;
import com.kovrizhkin.courier.entity.type.TaskStatus;
import com.kovrizhkin.courier.repository.CallCenterTaskRepository;

import java.util.List;

public interface CallCenterActionService {
    List<CallCenterTask> getTasksToCall();

    void saveCallResult(int taskId, TaskStatus taskStatus, String taskComment);

}

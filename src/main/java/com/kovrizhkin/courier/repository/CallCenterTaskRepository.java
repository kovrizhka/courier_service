package com.kovrizhkin.courier.repository;

import com.kovrizhkin.courier.entity.CallCenterTask;

import java.util.ArrayList;
import java.util.List;

public class CallCenterTaskRepository {
    private static final List<CallCenterTask> callCenterTasks = new ArrayList<>();

    public List<CallCenterTask> getCallCenterTasks() {
        return callCenterTasks;
    }
}

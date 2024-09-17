package com.ucb.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkFlowService {
    List<WorkFlow> list = new ArrayList<>();

    public List<WorkFlow> obtainList() {
        return this.list;
    }

    public void create(WorkFlow workFlow) {
        this.list.add(workFlow);
    }

    public WorkFlow read(String name) {
        return this.list.stream()
                .filter(workFlow -> workFlow.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void update(WorkFlow workFlow) {
        int index = this.list.indexOf(workFlow);
        if (index != -1) {
            this.list.set(index, workFlow);
        }
    }

    public void delete(WorkFlow workFlow) {
        this.list.remove(workFlow);
    }
}

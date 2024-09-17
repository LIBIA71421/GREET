package com.ucb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-flows")
public class WorkFlowController {

    @Autowired
    WorkFlowService workFlowService;
//    WorkFlowController(WorkFlowService workFlowService){
//        this.workFlowService
//    }


    @GetMapping
    public List<WorkFlow> list(){
    return workFlowService.obtainList();
    }

    @PostMapping()
    public void save(
            @RequestBody WorkFlowDto workFlowDto
    ){
        WorkFlow workFlow = new WorkFlow(
                workFlowDto.name(),
                workFlowDto.description()
        );
        this.workFlowService.create(workFlow);
    }
    @GetMapping("/{name}")
    public ResponseEntity<WorkFlow> read(@PathVariable String name) {
        WorkFlow workFlow = workFlowService.read(name);
        return workFlow != null ? ResponseEntity.ok(workFlow) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> update(@PathVariable String name, @RequestBody WorkFlowDto workFlowDto) {
        WorkFlow existingWorkFlow = workFlowService.read(name);
        if (existingWorkFlow != null) {
            WorkFlow updatedWorkFlow = new WorkFlow(
                    workFlowDto.name(),
                    workFlowDto.description()
            );
            workFlowService.update(updatedWorkFlow);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        WorkFlow existingWorkFlow = workFlowService.read(name);
        if (existingWorkFlow != null) {
            workFlowService.delete(existingWorkFlow);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

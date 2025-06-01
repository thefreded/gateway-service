package com.freded.gateway.task.controller;

import com.freded.dtos.TaskDTO;
import com.freded.dtos.TaskFileDTO;
import com.freded.dtos.TaskFileQueryDTO;
import com.freded.file.client.TaskFileClient;
import com.freded.gateway.task.dtos.TaskWithFilesDTO;
import com.freded.task.client.TaskClient;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class TaskService {


    @Inject
    TaskClient taskClient;

    @Inject
    TaskFileClient taskFileClient;

    @Inject
    TaskWithFilesMapper taskWithFilesMapper;

    public TaskWithFilesDTO getFilesForTask(final String taskId, final TaskFileQueryDTO taskFileQueryDTO) {

        TaskDTO taskDTO = taskClient.get(taskId);

        if (taskDTO == null) {
            return null;
        }
        TaskWithFilesDTO taskWithFilesDTO = taskWithFilesMapper.toTaskWithFiles(taskDTO);

        if (!taskFileQueryDTO.isLoadFiles()) {
            return taskWithFilesDTO;
        }

        List<TaskFileDTO> taskFiles = taskFileClient.getFilesForTask(taskId, taskFileQueryDTO);

        taskWithFilesDTO.setTaskFiles(taskFiles);
        
        return taskWithFilesDTO;
    }
}

package com.freded.gateway.task.controller;

import com.freded.dtos.TaskDTO;
import com.freded.dtos.TaskFileDTO;
import com.freded.dtos.TaskFileQueryDTO;
import com.freded.file.client.TaskFileClient;
import com.freded.gateway.task.dtos.TaskResponseDTO;
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
    TaskResponseMapper taskWithFilesMapper;

    public TaskResponseDTO getTask(final String taskId, final TaskFileQueryDTO taskFileQueryDTO) {

        TaskDTO taskDTO = taskClient.get(taskId);

        if (taskDTO == null) {
            return null;
        }
        TaskResponseDTO taskResponseDTO = taskWithFilesMapper.toTaskWithFiles(taskDTO);

        if (!taskFileQueryDTO.isLoadFiles()) {
            return taskResponseDTO;
        }

        return this.getFilesForTask(taskResponseDTO, taskFileQueryDTO);
    }

    private TaskResponseDTO getFilesForTask(final TaskResponseDTO taskResponseDTO, TaskFileQueryDTO taskFileQueryDTO) {

        List<TaskFileDTO> taskFiles = taskFileClient.getFilesForTask(taskResponseDTO.getId(), taskFileQueryDTO);

        taskResponseDTO.setTaskFiles(taskFiles);

        return taskResponseDTO;
    }


}

package com.freded.gateway.task.controller;

import com.freded.dtos.TaskDTO;
import com.freded.dtos.TaskFileDTO;
import com.freded.dtos.TaskFileQueryDTO;
import com.freded.file.client.TaskFileRestClient;
import com.freded.gateway.task.dtos.TaskResponseDTO;
import com.freded.task.client.TaskRestClient;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@RequestScoped
public class TaskService {


    @Inject
    @RestClient
    TaskRestClient taskClient;

    @Inject
    @RestClient
    TaskFileRestClient taskFileClient;

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

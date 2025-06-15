package com.freded.gateway.file.controller;

import com.freded.dtos.TaskDTO;
import com.freded.dtos.TaskFileDTO;
import com.freded.dtos.TaskFileUploadDTO;
import com.freded.file.client.TaskFileRestClient;
import com.freded.task.client.TaskRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@ApplicationScoped
public class FileService {

    @Inject
    @RestClient
    TaskFileRestClient taskFileClient;

    @Inject
    @RestClient
    TaskRestClient taskRestClient;

    public TaskFileDTO uploadFileToTask(final String taskId, final TaskFileUploadDTO taskFileUploadDTO) {

        if (this.validateTaskId(taskId)) {
            return taskFileClient.uploadFileToTask(taskId, taskFileUploadDTO);
        }
        
        throw new NotFoundException("Task with Id does not exist");
    }


    private Boolean validateTaskId(final String taskId) {
        TaskDTO taskDTO = taskRestClient.get(taskId);

        return taskDTO != null;
    }
}

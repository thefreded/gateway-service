package com.freded.gateway.file.controller;


import com.freded.file.client.TaskFileRestClient;
import com.freded.file.client.dto.TaskFileDTO;
import com.freded.file.client.dto.TaskFileUploadDTO;
import com.freded.task.client.TaskRestClient;
import com.freded.task.client.dto.TaskDTO;
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

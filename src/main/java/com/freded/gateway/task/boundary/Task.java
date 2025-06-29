package com.freded.gateway.task.boundary;


import com.freded.file.client.dto.TaskFileQueryDTO;
import com.freded.gateway.task.controller.TaskService;
import com.freded.gateway.task.dto.TaskResponseDTO;
import com.freded.task.client.TaskRestClient;
import com.freded.task.client.dto.TaskDTO;
import com.freded.task.client.dto.TaskPaginationAndSortingDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("tasks")
public class Task {

    @Inject
    @RestClient
    TaskRestClient taskClient;

    @Inject
    TaskService taskService;


    @POST
    public TaskDTO create(final TaskDTO task) {
        return taskClient.create(task);
    }

    @GET
    @Path("{taskId}")
    public TaskResponseDTO get(@PathParam("taskId") final String taskId,
            @BeanParam final TaskFileQueryDTO taskFileQueryDTO) {
        return taskService.getTask(taskId, taskFileQueryDTO);
    }

    @GET
    public List<TaskDTO> getAll(@BeanParam final TaskPaginationAndSortingDTO taskPaginationAndSortingDTO) {
        return taskClient.getAll(taskPaginationAndSortingDTO);
    }

    @DELETE
    @Path("{taskId}")
    public String delete(@PathParam("taskId") final String taskId) {
        return taskClient.delete(taskId);
    }

    @PUT
    @Path("{taskId}")
    public TaskDTO update(@PathParam("taskId") final String taskId, final TaskDTO task) {
        return taskClient.update(taskId, task);
    }
}





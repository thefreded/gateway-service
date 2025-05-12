package com.freded.gateway.task;


import com.freded.dtos.TaskDTO;
import com.freded.entities.TaskEntity;
import com.freded.task.client.TaskClient;
import com.freded.task.client.entity.TaskQueryDTO;
import com.freded.task.client.entity.TaskSortAndPaginationDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("tasks")
public class TaskResource {

    @Inject
    TaskClient taskClient;


    @POST
    public TaskDTO create(final TaskDTO task){
       return taskClient.create(task);
    }

    @GET
    @Path("{taskId}")
    public TaskDTO get(@PathParam("taskId") final String taskId, @BeanParam final TaskQueryDTO taskParams){
        return taskClient.get(taskId, taskParams);
    }
    @GET
    public List<TaskDTO> getAll(@BeanParam final TaskSortAndPaginationDTO qParams){
       return  taskClient.getAll(qParams);
    }

    @DELETE
    @Path("{taskId}")
    public String delete(@PathParam("taskId") final String taskId){
        return taskClient.delete(taskId);
    }
    @PUT
    @Path("{taskId}")
    public TaskDTO update(@PathParam("taskId") final String taskId, final TaskDTO task){
        return taskClient.update(taskId, task);
    }
}





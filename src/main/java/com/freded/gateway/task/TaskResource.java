package com.freded.gateway.task;


import com.freded.dtos.TaskDTO;
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
}

package com.freded.gateway.file;

import com.freded.dtos.TaskFileDTO;
import com.freded.file.client.TaskFileClient;
import com.freded.file.client.entity.TaskFileSortAndPaginationDTO;
import com.freded.file.client.entity.TaskFileUploadDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("document")
public class FileResource {

    @Inject
    TaskFileClient taskFileClient;

    @POST
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public TaskFileDTO uploadFileToTask(@PathParam("taskId") final String taskId, TaskFileUploadDTO form) {
        return taskFileClient.uploadFileToTask(taskId, form);
    }

    @GET
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<TaskFileDTO> getFilesForTask(@PathParam("taskId") final String taskId, @BeanParam final TaskFileSortAndPaginationDTO qParams) {
        return taskFileClient.getFilesForTask(taskId, qParams);
    }

    @GET
    @Path("{taskFileId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskFileDTO getFileDetails(@PathParam("taskFileId") final String taskFileId) {
        return taskFileClient.getFileDetails(taskFileId);
    }

}

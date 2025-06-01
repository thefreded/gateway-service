package com.freded.gateway.file.boundary;

import com.freded.dtos.TaskFileDTO;
import com.freded.dtos.TaskFilePaginationAndSortingDTO;
import com.freded.dtos.TaskFileUploadDTO;
import com.freded.file.client.TaskFileClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("document")
public class TaskFile {

    @Inject
    TaskFileClient taskFileClient;

    @POST
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public TaskFileDTO uploadFileToTask(@PathParam("taskId") final String taskId,
            @BeanParam final TaskFileUploadDTO taskFileUploadDTO) {
        return taskFileClient.uploadFileToTask(taskId, taskFileUploadDTO);
    }

    @GET
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<TaskFileDTO> getFilesForTask(@PathParam("taskId") final String taskId,
            @BeanParam final TaskFilePaginationAndSortingDTO taskFilePaginationAndSortingDTO) {
        return taskFileClient.getFilesForTask(taskId, taskFilePaginationAndSortingDTO);
    }

    @GET
    @Path("{taskFileId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskFileDTO getFileDetails(@PathParam("taskFileId") final String taskFileId) {
        return taskFileClient.getFileDetails(taskFileId);
    }

}

package com.freded.gateway.file.boundary;


import com.freded.file.client.TaskFileRestClient;
import com.freded.file.client.dto.TaskFileDTO;
import com.freded.file.client.dto.TaskFilePaginationAndSortingDTO;
import com.freded.file.client.dto.TaskFileUploadDTO;
import com.freded.gateway.file.controller.FileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("document")
public class TaskFile {

    @Inject
    @RestClient
    TaskFileRestClient taskFileClient;

    @Inject
    FileService fileService;

    @POST
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public TaskFileDTO uploadFileToTask(@PathParam("taskId") final String taskId,
            @BeanParam final TaskFileUploadDTO taskFileUploadDTO) {
        return fileService.uploadFileToTask(taskId, taskFileUploadDTO);
    }

    @GET
    @Path("task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskFileDTO> getFilesForTask(@PathParam("taskId") final String taskId,
            @BeanParam final TaskFilePaginationAndSortingDTO taskFilePaginationAndSortingDTO) {
        return taskFileClient.getFilesForTask(taskId, taskFilePaginationAndSortingDTO);
    }

    @GET
    @Path("{taskFileId}")
    @Produces(MediaType.APPLICATION_JSON)
    public TaskFileDTO getFileDetails(@PathParam("taskFileId") final String taskFileId) {
        return taskFileClient.getFileDetails(taskFileId);
    }

    @GET
    @Path("preview/{taskFileId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFileUrl(@PathParam("taskFileId") final String taskFileId) {
        return taskFileClient.getFileUrl(taskFileId);
    }
}

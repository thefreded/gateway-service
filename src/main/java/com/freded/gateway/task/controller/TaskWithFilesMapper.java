package com.freded.gateway.task.controller;


import com.freded.dtos.TaskDTO;
import com.freded.gateway.task.dtos.TaskWithFilesDTO;
import org.mapstruct.Mapper;

@Mapper()
public interface TaskWithFilesMapper {

    TaskWithFilesDTO toTaskWithFiles(TaskDTO taskDTO);

}

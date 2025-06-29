package com.freded.gateway.task.controller;


import com.freded.gateway.task.dto.TaskResponseDTO;
import com.freded.task.client.dto.TaskDTO;
import org.mapstruct.Mapper;

@Mapper()
public interface TaskResponseMapper {

    TaskResponseDTO toTaskWithFiles(TaskDTO taskDTO);

}

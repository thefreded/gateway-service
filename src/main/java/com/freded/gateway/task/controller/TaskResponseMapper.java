package com.freded.gateway.task.controller;


import com.freded.dtos.TaskDTO;
import com.freded.gateway.task.dtos.TaskResponseDTO;
import org.mapstruct.Mapper;

@Mapper()
public interface TaskResponseMapper {

    TaskResponseDTO toTaskWithFiles(TaskDTO taskDTO);

}

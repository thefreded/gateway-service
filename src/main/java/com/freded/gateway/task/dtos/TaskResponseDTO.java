package com.freded.gateway.task.dtos;

import com.freded.dtos.TaskDTO;
import com.freded.dtos.TaskFileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO extends TaskDTO {

    private List<TaskFileDTO> taskFiles = new ArrayList<>();
}

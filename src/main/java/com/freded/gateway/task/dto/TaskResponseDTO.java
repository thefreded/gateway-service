package com.freded.gateway.task.dto;


import com.freded.file.client.dto.TaskFileDTO;
import com.freded.task.client.dto.TaskDTO;
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

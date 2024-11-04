package com.dkd.manage.domain.vo;


import com.dkd.manage.domain.TbTask;
import com.dkd.manage.domain.TbTaskType;
import lombok.Data;

@Data
public class TaskVo extends TbTask {
    private TbTaskType taskType;
}

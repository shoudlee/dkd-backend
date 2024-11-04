package com.dkd.manage.domain.dto;

import com.dkd.manage.domain.TbChannel;
import lombok.Data;

import java.util.List;

@Data
public class ChannelConfigDto {
    private String innerCode;
    private List<ChannelSkuDto> channelList;
}

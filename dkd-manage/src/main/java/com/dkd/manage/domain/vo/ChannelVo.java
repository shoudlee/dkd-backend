package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.TbChannel;
import com.dkd.manage.domain.TbSku;
import lombok.Data;

@Data
public class ChannelVo extends TbChannel {
    private TbSku sku;
}

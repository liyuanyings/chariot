package com.example.sys.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lichunqing
 */
@Data
@Accessors(chain = true)
public class SysUploadFile {

    private Long id;

    /**
     * 关联业务id
     */
    private Long businessId;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 原始文件名称
     */
    private String originFileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件保存名称
     */
    private String saveName;

    /**
     * 创建时间
     */
    private Date createdTime;
}

package com.chen.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenzepeng
 * @date 2019-08-14
 */
@Data
public class TextDO implements Serializable {
    private static final long serialVersionUID = -3233115323379370989L;

    private Long id;

    private String value;
}

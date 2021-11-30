package com.ms.shop.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDTO {
        private int status;
        private String message;
        private Date timestamp;
}


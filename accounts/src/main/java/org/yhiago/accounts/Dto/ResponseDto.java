package org.yhiago.accounts.Dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String statusMsg;

    private String statusCode;

    public ResponseDto(String status201, String message201) {
        this.statusCode = status201;
        this.statusMsg = message201;
    }
}

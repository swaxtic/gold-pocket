package com.enigma.challengegoldpocket.format;

import java.time.LocalDateTime;

public class WrapperMessage<T>{
    private Integer responseCode;
    private String description;
    private LocalDateTime timestamp;
    private T data;
    // T nya adalah objek apapun


    public WrapperMessage(Integer responseCode, String description, T data) {
        this.responseCode = responseCode;
        this.description = description;
        this.data = data;
    }

    public static <T> WrapperMessage<T> commonResponse(Integer code, T data){
        return new WrapperMessage<>(code,"SUCCESS",data);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
//wrapper message
// t nya generic class apapun, cetakan class apapun
// balikannya responmessage
// responmessage untuk membuat response code internal
// dan mem wrapping

// respponse entity lebih disarankan
// bisa di combine

//Bisa juga untuk custom response pagination
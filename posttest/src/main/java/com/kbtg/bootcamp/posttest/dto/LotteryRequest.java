package com.kbtg.bootcamp.posttest.dto;

public class LotteryRequest {
    private String userId;
    private String ticketId;

    // Constructor, getters, and setters

    public LotteryRequest() {
    }

    public LotteryRequest(String userId, String ticketId) {
        this.userId = userId;
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

}


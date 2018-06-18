package com.sherpa.v1.weather;

import lombok.Data;

@Data
public class SpecialReportDTO {
    private String alertSummary;
    private String alertMessage;

    public SpecialReportDTO(String alertSummary, String alertMessage) {
        this.alertSummary = alertSummary;
        this.alertMessage = alertMessage;
    }
}

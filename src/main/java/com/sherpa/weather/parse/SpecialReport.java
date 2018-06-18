package com.sherpa.weather.parse;

import com.sherpa.v1.weather.SpecialReportDTO;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class SpecialReport {
    Map<String, String> alert60;
    Map<String, String> alert51;
    String areaName;

    public SpecialReportDTO toSpecialReportDTO() {

        return new SpecialReportDTO(getAlertSummary(alert51, areaName), getAlertMessage(alert60));
    }

    public String getAlertMessage(Map<String, String> alert60){
        String alertMessage = "";
        Set<String> keys = alert60.keySet();
        for(String key : keys) {
            alertMessage += alert60.get(key) + "\n";
        }
        return alertMessage;
    }

    public String getAlertSummary(Map<String, String> alert51, String areaName) {
        String alertSummary = "";
        alertSummary += areaName + "지역" + alert51.get("varName") + " " + alert51.get("stressName") + " " + alert51.get("cmdName");
        return alertSummary;
    }
}

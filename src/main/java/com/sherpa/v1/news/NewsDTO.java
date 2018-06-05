package com.sherpa.v1.news;

import lombok.Data;

@Data
public class NewsDTO {
    private String title;
    private String link;
    private String description;
    private String pubDate;
}

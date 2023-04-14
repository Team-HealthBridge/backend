package com.vitalis.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "health_events")
public class HealthEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "Title is required")
    private String title;
    @Column(name = "description")
    @NotBlank(message = "Description is required")
    private String description;
    @Column(name = "picture_url")
    @NotBlank(message = "Picture URL is required")
    @Pattern(regexp = "^(http|https)://[^\\s/$.?#].\\S*$", message = "Invalid URL format")
    private String pictureUrl;

    @Column(name = "learn_more_url")
    @NotBlank(message = "Learn more URL is required")
    @Pattern(regexp = "^(http|https)://[^\\s/$.?#].\\S*$", message = "Invalid URL format")
    private String learnMoreUrl;

    @Column(name = "start_date")
    @NotBlank(message = "Start date is required")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", message = "Invalid date format")
    private String startDate;
    @Column(name = "end_date")
    @NotBlank(message = "End date is required")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", message = "Invalid date format")
    private String endDate;

    public HealthEvent() {
    }
     public HealthEvent(Long id, String title, String description, String pictureUrl, String learnMoreUrl, String startDate, String endDate) {
         this.id = id;
         this.title = title;
         this.description = description;
         this.pictureUrl = pictureUrl;
         this.learnMoreUrl = learnMoreUrl;
         this.startDate = startDate;
         this.endDate = endDate;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getLearnMoreUrl() {
        return learnMoreUrl;
    }

    public void setLearnMoreUrl(String learnMoreUrl) {
        this.learnMoreUrl = learnMoreUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

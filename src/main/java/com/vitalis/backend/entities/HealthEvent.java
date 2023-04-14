package com.vitalis.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Date;


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
    @NotNull(message = "Start date is required")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @NotNull(message = "End date is required")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public HealthEvent() {
    }
     public HealthEvent(Long id, String title, String description, String pictureUrl, String learnMoreUrl, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

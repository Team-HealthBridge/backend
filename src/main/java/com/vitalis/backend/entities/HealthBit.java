package com.vitalis.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "health_bits")
public class HealthBit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    @NotNull(message = "Category is required")
    private String category;

    @Column(name = "description")
    @NotBlank(message = "Description is required")
    @Size(min = 10,  message = "Description must be atleast 10 characters long")
    private String description;

    @Column(name = "picture_url")
    @Pattern(regexp = "^(http|https)://[^\\s/$.?#].\\S*$", message = "Invalid URL format")
    @NotEmpty(message = "Picture URL is required")
    private String pictureUrl;

    public HealthBit() {
    }

    public HealthBit(Long id, String category, String description, String pictureUrl) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.pictureUrl = pictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void setPictureUrl(String picture) {
        this.pictureUrl = picture;
    }
}

package id.go.bpddiy.social.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/*
* Relasi Post (N) -- (1) User
*
*/

@Entity
@Table(name = "posts", indexes = {
        @Index(name = "idx_post_author", columnList = "author_id"),
        @Index(name = "idx_post_slug", columnList = "slug")
})
public class Post {

    public Post(Long id,
            @NotBlank(message = "Title is mandatory") @Size(min = 5, max = 200, message = "Title must be less than 5 until 200 characters") String title,
            String slug, @NotBlank(message = "Content is mandatory") String content, LocalDateTime publishedAt,
            LocalDateTime createdAt, LocalDateTime updatedAt, User author, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 5, max = 200, message = "Title must be less than 5 until 200 characters")
    @Column(nullable = false, length = 200)
    private String title;

    // slug, teks singkat, biasanya untuk URL
    @Column(nullable = false, length = 200, unique = true)
    private String slug;

    @NotBlank(message = "Content is mandatory")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relasi ke user,
    // FetchType.LAZY, optimalisasi performa, akses db berdasarkan relasi, jika
    // ditemukan, maka dicari data di tabel foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "fk_post_user_author"))
    private User author;

    // One to Many dengan comment
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("createdAt DESC")
    private List<Comment> comments;

    // getter setter

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}

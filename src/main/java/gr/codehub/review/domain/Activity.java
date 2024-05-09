package gr.codehub.review.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTIVITIES")
public class Activity extends BaseModel {

    @ManyToOne
    private Author author;

    @ManyToOne
    private Content content;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal fee;

    public Activity(final Content content, final Author author, final BigDecimal fee) {
        this.content = content;
        this.author = author;
        this.fee = fee;
    }
}

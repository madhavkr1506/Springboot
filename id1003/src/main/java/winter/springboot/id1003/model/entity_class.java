package winter.springboot.id1003.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class entity_class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("ticker")
    private String stockname;
    @JsonProperty("o")
    private double openprice;
    @JsonProperty("c")
    private double closeprice;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
    

}

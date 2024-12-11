package winter.springboot.id004.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class entity_class {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "First Name")
    private String firstname;
    @Column(name ="Last Name")
    private String lastname;
    @Column(name ="Email Id")
    private String email;
    @Column(name ="Mobile No")
    private String mobile;
}

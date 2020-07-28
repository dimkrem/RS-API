package gr.codehub.rsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //dof = date of finalized
    private LocalDate dof;

    public enum type {
        MANUAL,
        AUTO,
        PARTIAL
    }

    private type t;
    private boolean isFinalized;

    @ManyToOne
    @JsonIgnore
    private Applicant applicant;

    @ManyToOne
    @JsonIgnore
    private JobOffer jobOffer;
}
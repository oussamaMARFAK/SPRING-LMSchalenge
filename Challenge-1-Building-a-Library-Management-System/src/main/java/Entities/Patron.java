package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "patrons")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Patron {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "patronName")
    private  String patronName;
    @Column(name = "patronEmail")
    private  String patronEmail;
    @Column(name = "booksBrowed")
    private String booksBrowed;









}

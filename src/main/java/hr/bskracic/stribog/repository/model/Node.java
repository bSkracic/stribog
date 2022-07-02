package hr.bskracic.stribog.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "node")
@Data
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String containerId;
}


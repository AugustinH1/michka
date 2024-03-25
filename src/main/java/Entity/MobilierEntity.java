package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mobilier")
public class MobilierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piece")
    private PieceEntity idPiece;

    @Column(name = "description")
    private String description;

    @Column(name = "nature")
    private String nature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PieceEntity getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(PieceEntity idPiece) {
        this.idPiece = idPiece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

}
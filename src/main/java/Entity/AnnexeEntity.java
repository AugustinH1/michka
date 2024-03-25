package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "annexe")
public class AnnexeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "num_bien")
    private BienEntity numBien;

    @Column(name = "surface")
    private Integer surface;

    @Column(name = "num_annexe")
    private Integer numAnnexe;

    @Column(name = "nb_piece")
    private Integer nbPiece;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BienEntity getNumBien() {
        return numBien;
    }

    public void setNumBien(BienEntity numBien) {
        this.numBien = numBien;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getNumAnnexe() {
        return numAnnexe;
    }

    public void setNumAnnexe(Integer numAnnexe) {
        this.numAnnexe = numAnnexe;
    }

    public Integer getNbPiece() {
        return nbPiece;
    }

    public void setNbPiece(Integer nbPiece) {
        this.nbPiece = nbPiece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
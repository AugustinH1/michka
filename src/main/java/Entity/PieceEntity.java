package Entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "piece")
public class PieceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "num_bien")
    private BienEntity numBien;

    @Column(name = "id_affectation")
    private Integer idAffectation;

    @Column(name = "description")
    private String description;

    @Column(name = "surface")
    private Integer surface;

    @Column(name = "nb_murs")
    private Integer nbMurs;

    @Column(name = "nb_portes")
    private Integer nbPortes;

    @Column(name = "nb_fenetre")
    private Integer nbFenetre;

    @Column(name = "affectation_piece")
    private String affectationPiece;

    @OneToMany(mappedBy = "idPiece")
    private Set<MobilierEntity> mobiliers = new LinkedHashSet<>();

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

    public Integer getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getNbMurs() {
        return nbMurs;
    }

    public void setNbMurs(Integer nbMurs) {
        this.nbMurs = nbMurs;
    }

    public Integer getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(Integer nbPortes) {
        this.nbPortes = nbPortes;
    }

    public Integer getNbFenetre() {
        return nbFenetre;
    }

    public void setNbFenetre(Integer nbFenetre) {
        this.nbFenetre = nbFenetre;
    }

    public String getAffectationPiece() {
        return affectationPiece;
    }

    public void setAffectationPiece(String affectationPiece) {
        this.affectationPiece = affectationPiece;
    }

    public Set<MobilierEntity> getMobiliers() {
        return mobiliers;
    }

    public void setMobiliers(Set<MobilierEntity> mobiliers) {
        this.mobiliers = mobiliers;
    }

}
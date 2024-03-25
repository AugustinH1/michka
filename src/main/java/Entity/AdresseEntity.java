package Entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "adresse")
public class AdresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "num_rue")
    private Integer numRue;

    @Column(name = "nom_rue")
    private String nomRue;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "etage")
    private Integer etage;

    @Column(name = "num_logement")
    private Integer numLogement;

    @OneToMany(mappedBy = "idAdresse")
    private Set<BienEntity> biens = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumRue() {
        return numRue;
    }

    public void setNumRue(Integer numRue) {
        this.numRue = numRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getEtage() {
        return etage;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }

    public Integer getNumLogement() {
        return numLogement;
    }

    public void setNumLogement(Integer numLogement) {
        this.numLogement = numLogement;
    }

    public Set<BienEntity> getBiens() {
        return biens;
    }

    public void setBiens(Set<BienEntity> biens) {
        this.biens = biens;
    }

}
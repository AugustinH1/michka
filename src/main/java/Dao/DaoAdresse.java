package Dao;

import Entity.AdresseEntity;

import java.util.List;

public interface DaoAdresse extends Dao<AdresseEntity> {
    public List<AdresseEntity> findBySearchCriteria(String searchText, String classification, String typeBien, String typeChauffage, String typeEauChaude);

}

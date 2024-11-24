package pe.edu.i202220098.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220098.Entity.City;
import pe.edu.i202220098.Entity.Country;
import pe.edu.i202220098.Entity.CountryLanguage;
import pe.edu.i202220098.Entity.CountryLanguageId;

import java.util.Set;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            Country imaginario = inicializarPais();

            asignarCiudades(imaginario);
            asignarLenguajes(imaginario);

            entityManager.persist(imaginario);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    private static Country inicializarPais() {
        return new Country(
                "PI", "Imaginario",
                "3", "Imaginaria", 1005600.0,
                25600, 2034500, 60.0, 67800.0,
                48000.0, "Imaginaria",
                "República", "Frank Narro",
                1, "IM", null, null
        );
    }

    private static void asignarCiudades(Country country) {
        country.setCities(Set.of(
                new City(null, "city 1", country, "D1", 1000000),
                new City(null, "city 2", country, "D2", 2000000),
                new City(null, "city3", country, "D3", 1500000)
        ));
    }

    private static void asignarLenguajes(Country country) {

        CountryLanguageId lang1Id = new CountryLanguageId();
        lang1Id.setCountryCode(country.getCode());
        lang1Id.setLanguage("Imaginario");

        CountryLanguage lang1 = new CountryLanguage(lang1Id, country, "T", 90.0);

        CountryLanguageId lang2Id = new CountryLanguageId();
        lang2Id.setCountryCode(country.getCode());
        lang2Id.setLanguage("Imaginario2");

        CountryLanguage lang2 = new CountryLanguage(lang2Id, country, "T", 80.0);

        country.setCountryLanguages(Set.of(lang1, lang2));
    }
}

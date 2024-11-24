package pe.edu.i202220098.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220098.Entity.Country;

import java.util.Optional;

public class JPAFind {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Optional.ofNullable(em.find(Country.class, "PER"))
                .map(Country::getCities)
                .ifPresent(cities -> cities.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("Las Ciudadades Peruanas con población > 700000 son: " + city.getName())));

        em.close();
        emf.close();
    }
}


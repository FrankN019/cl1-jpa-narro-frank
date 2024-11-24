package pe.edu.i202220098.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220098.Entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            Country country = em.find(Country.class, "PI");
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();

            System.out.println("Eliminación exitosa: El país y sus ciudades y lenguajes han sido eliminados.");
        } catch (NullPointerException e) {
            System.out.println("El país no se encuentra en la base de datos.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el país: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}

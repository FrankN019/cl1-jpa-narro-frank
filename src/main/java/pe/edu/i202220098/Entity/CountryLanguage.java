package pe.edu.i202220098.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private Double percentage;

    public CountryLanguage() {}


    public CountryLanguage(CountryLanguageId id, Country country, String isOfficial, Double percentage) {
        this.id = id;
        this.country = country;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", country=" + country.getCode() +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
    // Getters y Setters
    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

        public void setIsOfficial(String isOfficial) {
            this.isOfficial = isOfficial;
        }

        public Double getPercentage() {
            return percentage;
        }

        public void setPercentage(Double percentage) {
            this.percentage = percentage;
        }


    }



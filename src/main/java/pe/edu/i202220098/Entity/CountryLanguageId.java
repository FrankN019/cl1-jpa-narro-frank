package pe.edu.i202220098.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
    @Embeddable
public class CountryLanguageId implements Serializable {
    private String countryCode;
    private String language;

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return countryCode.equals(that.countryCode) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return 31 * countryCode.hashCode() + language.hashCode();
    }
}

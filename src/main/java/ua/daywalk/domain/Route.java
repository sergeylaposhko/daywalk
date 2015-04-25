package ua.daywalk.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;

@Document
@XmlRootElement
public class Route {

    @Id
    private String id;

    private String country;

    private String city;

    private String title;

    private String preview;

    public Route(String id, String country, String city, String title, String preview) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.title = title;
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", title='" + title + '\'' +
                ", preview=" + preview +
                '}';
    }
}

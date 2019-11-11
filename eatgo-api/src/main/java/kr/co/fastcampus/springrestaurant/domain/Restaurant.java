package kr.co.fastcampus.springrestaurant.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    @Setter
    private Long id;
    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItems(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}

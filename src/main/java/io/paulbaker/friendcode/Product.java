package io.paulbaker.friendcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by paulbaker on 12/23/16.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable, Comparable<Product> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Override
    public int compareTo(Product o) {
        return Long.compare(getId(), o.getId());
    }
}

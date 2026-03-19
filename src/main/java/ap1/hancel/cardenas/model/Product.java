package ap1.hancel.cardenas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;
    private String state;
    private Date createdAt;
}
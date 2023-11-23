package kr.sungwoo.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "user")
public class UserDocument {

    @Id
    private String _id;
    private String uid;
    private String name;
    private int age;
    private String addr;
}

package postMethodTests.CreateMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateResponsePojo {
    @Getter
    private String name;
    @Getter
    private String job;
    @Getter
    private String id;
    @Getter
    private Date createdAt;
}

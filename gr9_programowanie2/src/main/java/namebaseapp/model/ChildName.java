package namebaseapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChildName {
    private Integer year;
    private String name;
    private Integer count;
    private SexType sex;
}

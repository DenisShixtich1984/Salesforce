package utils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
public class Account {
    private String accountName;
    private String phone;
    private String fax;
    private String website;
    private String parent;
    private String employees;
    private String annualrevenue;
    private String type;
    private String industry;

}
